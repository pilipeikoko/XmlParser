package org.epam.xmltask.builder;

import org.epam.xmltask.entity.AdvertisingPostcard;
import org.epam.xmltask.entity.Postcard;

import java.time.LocalDate;

public class AdvertisingPostcardBuilder extends PostcardBuilder{


    public AdvertisingPostcardBuilder() {
        super();
    }

    @Override
    public Postcard createPostcard() {
        AdvertisingPostcard advertisingPostcard;

        if (attributes.size() == 1) {

            advertisingPostcard = new AdvertisingPostcard(elements.get(0), Boolean.parseBoolean(elements.get(1)),
                    elements.get(2), LocalDate.parse(elements.get(3)), elements.get(4), elements.get(5),
                    attributes.get(0),elements.get(6),LocalDate.parse(elements.get(7)));
        } else {
            advertisingPostcard = new AdvertisingPostcard(elements.get(0), Boolean.parseBoolean(elements.get(1)),
                    elements.get(2), LocalDate.parse(elements.get(3)), elements.get(4), elements.get(5),
                    attributes.get(0),attributes.get(1),elements.get(6),LocalDate.parse(elements.get(7)));
        }

        return advertisingPostcard;
    }
}
