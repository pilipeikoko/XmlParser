package org.epam.xmltask.parser;

import org.epam.xmltask.builder.PostcardBuilder;
import org.epam.xmltask.builder.PostcardBuilderManager;
import org.epam.xmltask.entity.PostcardType;
import org.epam.xmltask.exception.CustomXmlParserException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PostcardStaxParser extends PostcardParser {
    private PostcardBuilder postcard;
    private boolean isPostcard;
    private String currentStringTagType;

    public PostcardStaxParser() {
        super();
        //todo remove = null

    }

    @Override
    public void createListOfPostcards(String path) throws CustomXmlParserException {
        XMLInputFactory inputFactory = XMLInputFactory.newFactory();

        PostcardBuilderManager builderManager = new PostcardBuilderManager();

        try {
            //todo pass not path
            FileInputStream inputStream = new FileInputStream(path);
            XMLStreamReader streamReader = inputFactory.createXMLStreamReader(inputStream);

            readXmlFile(streamReader);
        } catch (FileNotFoundException exception) {
            throw new CustomXmlParserException("File not found", exception.getCause());
        } catch (XMLStreamException exception) {
            //todo fix message
            throw new CustomXmlParserException("Stream exception", exception.getCause());
        }
    }

    private void readXmlFile(XMLStreamReader streamReader) throws XMLStreamException {
        String currentElement;

        PostcardBuilderManager builderManager = null;

        while (streamReader.hasNext()) {
            if (streamReader.isStartElement()) {

                currentStringTagType = streamReader.getLocalName();
                String currentUppedElement = currentStringTagType.toUpperCase();
                //todo add type validator for enums
                PostcardType postcardType = PostcardType.valueOf(currentUppedElement);
                isPostcard = true;

                builderManager = new PostcardBuilderManager();
                postcard = builderManager.createPostcard(postcardType);

                for (int i = 0; i < streamReader.getAttributeCount(); i++) {
                    postcard.addAttribute(streamReader.getAttributeValue(i));
                }
            }

            //todo add type validator
            postcard.addElement(getNextElementValue(streamReader));
        }

        if (streamReader.isEndElement()) {
            if (isPostcard && currentStringTagType.equals(streamReader.getLocalName())) {
                listOfPostcards.add(postcard.createPostcard());
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
