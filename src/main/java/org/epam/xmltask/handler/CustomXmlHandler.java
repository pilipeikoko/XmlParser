package org.epam.xmltask.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.xmltask.builder.PostcardBuilder;
import org.epam.xmltask.builder.PostcardBuilderManager;
import org.epam.xmltask.entity.Postcard;
import org.epam.xmltask.entity.OldCardsType;
import org.epam.xmltask.exception.CustomXmlParserException;
import org.epam.xmltask.validator.OldCardsEnumValidator;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CustomXmlHandler extends DefaultHandler {

    private final static Logger LOGGER = LogManager.getLogger();

    private final List<Postcard> listOfPostcards;
    private PostcardBuilder postcardBuilder;
    private boolean isPostcard;

    private OldCardsType oldCardsType;
    private String currentElementContent;

    public CustomXmlHandler() {
        listOfPostcards = new ArrayList<>();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) {
        try {
            if (OldCardsEnumValidator.isPostcardTypeCorrect(qName)) {
                isPostcard = true;

                String convertedQName = qName.toUpperCase().replaceAll("-", "_");
                oldCardsType = OldCardsType.valueOf(convertedQName);

                PostcardBuilderManager builderManager = new PostcardBuilderManager();
                postcardBuilder = builderManager.createPostcard(oldCardsType);

                if (postcardBuilder != null) {
                    IntStream.range(0, attributes.getLength())
                            .forEach(i -> postcardBuilder.addAttribute(attributes.getValue(i)));
                }
            }
        } catch (CustomXmlParserException exception) {
            LOGGER.warn("Unknown type: " + exception.getMessage());
            isPostcard = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (isPostcard) {

            postcardBuilder.addElement(currentElementContent);
        }
        if (isPostcard && oldCardsType.name().equals(qName.toUpperCase().replaceAll("-", "_"))) {

            Postcard currentPostcard = postcardBuilder.createPostcard();
            listOfPostcards.add(currentPostcard);

            oldCardsType = null;
            isPostcard = false;
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) {
        currentElementContent = new String(ch, start, length);
    }

    public List<Postcard> getListOfPostcards() {
        return listOfPostcards;
    }
}
