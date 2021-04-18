package org.epam.xmltask.parser;

import org.epam.xmltask.entity.Postcard;
import org.epam.xmltask.exception.CustomXmlParserException;

import java.util.ArrayList;
import java.util.List;

public abstract class PostcardParser {
    protected List<Postcard> listOfPostcards;

    public PostcardParser(){
        listOfPostcards = new ArrayList<>();
    }

    public List<Postcard> getListOfPostcards() {
        return listOfPostcards;
    }

    public abstract void createListOfPostcards(String path) throws CustomXmlParserException;
}
