package org.epam.xmltask.parser;

import org.epam.xmltask.entity.Postcard;

import java.util.ArrayList;
import java.util.List;

public abstract class PostcardParser {
    protected List<Postcard> setOfPostcards;

    public PostcardParser(){
        setOfPostcards = new ArrayList<>();
    }

    // todo add getter for field

    //abstract method createSet
}
