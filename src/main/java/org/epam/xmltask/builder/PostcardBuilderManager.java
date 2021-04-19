package org.epam.xmltask.builder;

import org.epam.xmltask.entity.OldCardsType;
import org.epam.xmltask.exception.CustomXmlParserException;

public class PostcardBuilderManager {

    public PostcardBuilder createPostcard(OldCardsType type) throws CustomXmlParserException {

        PostcardBuilder postcardBuilder;

        switch (type){
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
                throw new CustomXmlParserException("Unexpected value: " + type);
        }
        return postcardBuilder;
    }

    public PostcardBuilder createPostcard(String type) throws CustomXmlParserException {
        String uppedType = type.toUpperCase();

        PostcardBuilder postcardBuilder;

        switch (uppedType){
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
                throw new CustomXmlParserException("Unexpected value: " + type);
        }
        return postcardBuilder;
    }
}

