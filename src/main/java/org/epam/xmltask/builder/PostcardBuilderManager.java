package org.epam.xmltask.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.xmltask.entity.OldCardsType;
import org.epam.xmltask.exception.CustomXmlParserException;

public class PostcardBuilderManager {
    private final static Logger LOGGER = LogManager.getLogger();


    public PostcardBuilder createPostcard(OldCardsType type) throws CustomXmlParserException {

        PostcardBuilder postcardBuilder;

        switch (type) {
            case POSTCARD:
                postcardBuilder = new PostcardBuilder();
                break;
            case ADVERTISING_POSTCARD:
                postcardBuilder = new AdvertisingPostcardBuilder();
                break;
            case CONGRATULATORY_POSTCARD:
                postcardBuilder = new CongratulatoryPostcardBuilder();
                break;
            default:
                LOGGER.warn("Couldn't create postcard: incorrect type");
                throw new CustomXmlParserException("Unexpected value: " + type);
        }
        return postcardBuilder;
    }

    public PostcardBuilder createPostcard(String type) throws CustomXmlParserException {
        String uppedType = type.toUpperCase();

        PostcardBuilder postcardBuilder;

        switch (uppedType) {
            case "POSTCARD":
                postcardBuilder = new PostcardBuilder();
                break;
            case "ADVERTISING_POSTCARD":
                postcardBuilder = new AdvertisingPostcardBuilder();
                break;
            case "CONGRATULATORY_POSTCARD":
                postcardBuilder = new CongratulatoryPostcardBuilder();
                break;
            default:
                LOGGER.warn("Couldn't create postcard: incorrect type");
                throw new CustomXmlParserException("Unexpected value: " + type);
        }
        return postcardBuilder;
    }
}

