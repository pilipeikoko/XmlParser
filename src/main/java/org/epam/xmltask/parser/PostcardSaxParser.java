package org.epam.xmltask.parser;

import org.epam.xmltask.exception.CustomXmlParserException;
import org.epam.xmltask.handler.CustomXmlHandler;
import org.epam.xmltask.validator.OldCardsXmlValidator;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PostcardSaxParser extends PostcardParser {

    public PostcardSaxParser() {
        super();
    }

    @Override
    public void createListOfPostcards(String path) throws CustomXmlParserException {
        OldCardsXmlValidator.validateXml(path);

        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();

            SAXParser parser = parserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();

            CustomXmlHandler xmlHandler = new CustomXmlHandler();
            reader.setContentHandler(xmlHandler);

            File file = new File(ClassLoader.getSystemResource(path).getPath());
            FileInputStream inputStream = new FileInputStream(file);
            InputSource inputSource = new InputSource(inputStream);

            reader.parse(inputSource);

            this.listOfPostcards = xmlHandler.getListOfPostcards();

            LOGGER.info("Parsed successfully. Amount of found objects: " + listOfPostcards.size());

        } catch (IOException exception) {
            throw new CustomXmlParserException("IOE exception", exception.getCause());
        } catch (SAXException exception) {
            throw new CustomXmlParserException("SAX exception", exception.getCause());
        } catch (ParserConfigurationException exception) {
            throw new CustomXmlParserException("Configuration error", exception.getCause());
        }


    }


}
