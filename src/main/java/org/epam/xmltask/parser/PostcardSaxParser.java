package org.epam.xmltask.parser;

import org.epam.xmltask.handler.CustomXmlHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class PostcardSaxParser extends PostcardParser {

    public PostcardSaxParser() {
        super();
    }

    @Override
    public void createListOfPostcards(String path) {
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();

            SAXParser parser = parserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();

            CustomXmlHandler xmlHandler = new CustomXmlHandler();
            reader.setContentHandler(xmlHandler);

            //todo objects?
            URL url = Objects.requireNonNull(this.getClass().getResource("/data/Postcards.xml"));
            FileInputStream inputStream = new FileInputStream(url.getFile());
            InputSource inputSource = new InputSource(inputStream);

            reader.parse(inputSource);

            this.listOfPostcards = xmlHandler.getListOfPostcards();

        } catch (IOException| SAXException| ParserConfigurationException exception) {
            exception.printStackTrace();
            //todo
            //todo mb throws
        }


    }


}
