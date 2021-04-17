package org.epam.xmltask.builder;

import org.epam.xmltask.entity.Postcard;
import org.epam.xmltask.entity.PostcardAttributes;
import org.epam.xmltask.entity.PostcardElements;
import org.epam.xmltask.entity.PostcardType;

import java.util.List;
import java.util.Map;

public class PostcardBuilderManager {

    public PostcardBuilder createPostcard(PostcardType type) {

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
                //todo
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return postcardBuilder;
    }
}

