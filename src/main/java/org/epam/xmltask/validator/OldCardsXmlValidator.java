package org.epam.xmltask.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.xmltask.exception.CustomXmlParserException;
import org.epam.xmltask.handler.CustomErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class OldCardsXmlValidator {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SCHEMA_FILE_NAME = "oldCards.xsd";

    public static void validateXml(String path) throws CustomXmlParserException {

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            Source schemaSource = new StreamSource(SCHEMA_FILE_NAME);
            File schemaFile = new File(path);
            Schema schema = schemaFactory.newSchema(schemaFile);

            Validator validator = schema.newValidator();

            validator.setErrorHandler(new CustomErrorHandler());
            validator.validate(schemaSource);

        } catch (SAXException | IOException e) {
            throw new CustomXmlParserException("Wrong XML file: " + e.getMessage());
        }

    }
}
