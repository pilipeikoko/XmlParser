package org.epam.xmltask.parser;

import org.epam.xmltask.builder.PostcardBuilder;
import org.epam.xmltask.builder.PostcardBuilderManager;
import org.epam.xmltask.entity.OldCardsType;
import org.epam.xmltask.exception.CustomXmlParserException;
import org.epam.xmltask.validator.OldCardsEnumValidator;
import org.epam.xmltask.validator.OldCardsXmlValidator;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PostcardStaxParser extends PostcardParser {
    private PostcardBuilder postcard;
    private boolean isPostcard;

    public PostcardStaxParser() {
        super();
    }

    @Override
    public void createListOfPostcards(String path) throws CustomXmlParserException {
        OldCardsXmlValidator.validateXml(path);

        XMLInputFactory inputFactory = XMLInputFactory.newFactory();

        try {
            File file = new File(ClassLoader.getSystemResource(path).getPath());
            FileInputStream inputStream = new FileInputStream(file);
            XMLStreamReader streamReader = inputFactory.createXMLStreamReader(inputStream);

            readXmlFile(streamReader);

            LOGGER.info("Parsed successfully. Amount of found objects: " + listOfPostcards.size());

        } catch (FileNotFoundException exception) {
            throw new CustomXmlParserException("File not found", exception.getCause());
        } catch (XMLStreamException exception) {
            throw new CustomXmlParserException("Stream exception", exception.getCause());
        }
    }

    private void readXmlFile(XMLStreamReader streamReader) throws XMLStreamException, CustomXmlParserException {
        String currentElement = "";

        PostcardBuilderManager builderManager = new PostcardBuilderManager();

        while (streamReader.hasNext()) {
            streamReader.next();
            if (streamReader.isStartElement()) {

                String currentStringTagType = streamReader.getLocalName();
                String currentUppedStringTagType = currentStringTagType.toUpperCase();

                if (OldCardsEnumValidator.isPostcardTypeCorrect(currentStringTagType)) {
                    OldCardsType oldCardsType = OldCardsType.valueOf(currentUppedStringTagType.replaceAll("-", "_"));

                    isPostcard = true;

                    builderManager = new PostcardBuilderManager();
                    currentElement = currentStringTagType;
                    postcard = builderManager.createPostcard(oldCardsType);

                    for (int i = 0; i < streamReader.getAttributeCount(); i++) {
                        postcard.addAttribute(streamReader.getAttributeValue(i));
                    }
                }
                if (OldCardsEnumValidator.isPostcardElementCorrect(currentStringTagType)) {
                    postcard.addElement(getNextElementValue(streamReader));
                }
            }

            if (streamReader.isEndElement()) {
                if (isPostcard && currentElement.equals(streamReader.getLocalName())) {
                    listOfPostcards.add(postcard.createPostcard());
                }
            }
        }

    }

    private String getNextElementValue(XMLStreamReader streamReader) throws XMLStreamException {
        StringBuilder stringBuilder = new StringBuilder();

        if (streamReader.hasNext()) {
            stringBuilder = new StringBuilder();
            streamReader.next();
            stringBuilder.append(streamReader.getText());
        }

        return stringBuilder.toString();
    }
}
