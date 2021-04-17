package org.epam.xmltask.builder;

import org.epam.xmltask.entity.CongratulatoryPostcard;
import org.epam.xmltask.entity.Postcard;

import java.time.LocalDate;
import java.util.List;

public class CongratulatoryPostcardBuilder extends PostcardBuilder {
    public CongratulatoryPostcardBuilder() {
        super();
    }

    @Override
    public Postcard createPostcard() {
        CongratulatoryPostcard congratulatoryPostcard;


        if (attributes.size() == 1) {
            congratulatoryPostcard = new CongratulatoryPostcard(elements.get(0), elements.get(1), elements.get(2), elements.get(3),
                    Boolean.parseBoolean(elements.get(4)), LocalDate.parse(elements.get(5)), attributes.get(0),elements.get(6));
        } else {
            congratulatoryPostcard = new CongratulatoryPostcard(elements.get(0), elements.get(1), elements.get(2), elements.get(3),
                    Boolean.parseBoolean(elements.get(4)), LocalDate.parse(elements.get(5)), attributes.get(0),attributes.get(1),elements.get(6));
        }

        return congratulatoryPostcard;
    }

}
