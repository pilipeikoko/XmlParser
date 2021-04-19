package org.epam.xmltask.builder;

import org.epam.xmltask.entity.Postcard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostcardBuilder {
    protected List<String> elements;
    protected List<String> attributes;

    public PostcardBuilder() {
        this.attributes = new ArrayList<>();
        this.elements = new ArrayList<>();
    }

    public void addAttribute(String attribute){
        attributes.add(attribute);
    }

    public void addElement(String element){
        elements.add(element);
    }

    public Postcard createPostcard() {
        Postcard postcard;

        if (attributes.size() == 1) {
            postcard = new Postcard(elements.get(0), Boolean.parseBoolean(elements.get(1)), elements.get(2),
                    LocalDate.parse(elements.get(3)), elements.get(4), elements.get(5),
                    attributes.get(0));

        } else {
            postcard = new Postcard(elements.get(0), Boolean.parseBoolean(elements.get(1)), elements.get(2),
                    LocalDate.parse(elements.get(3)), elements.get(4), elements.get(5),
                    attributes.get(0),attributes.get(1));
        }

        return postcard;
    }
}
