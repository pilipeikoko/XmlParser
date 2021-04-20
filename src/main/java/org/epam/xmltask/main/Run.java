package org.epam.xmltask.main;

import org.epam.xmltask.exception.CustomXmlParserException;
import org.epam.xmltask.parser.PostcardDomParser;
import org.epam.xmltask.parser.PostcardParser;
import org.epam.xmltask.parser.PostcardSaxParser;
import org.epam.xmltask.parser.PostcardStaxParser;

public class Run {

    public static void main(String[] args) {
        String path = "data/oldCards.xml";
        try {
            PostcardParser postcardSaxParser = new PostcardSaxParser();
            postcardSaxParser.createListOfPostcards(path);

            PostcardParser postcardStaxParser = new PostcardStaxParser();
            postcardStaxParser.createListOfPostcards(path);

            PostcardParser postcardDomParser = new PostcardDomParser();
            postcardDomParser.createListOfPostcards(path);

            System.out.println("Sax parser result: " + postcardSaxParser.getListOfPostcards().toString());
            System.out.println("Stax parser result: " + postcardStaxParser.getListOfPostcards().toString());
            System.out.println("Dom parser result: " + postcardDomParser.getListOfPostcards().toString());


        } catch (CustomXmlParserException exception) {
            exception.printStackTrace();
        }
    }
}
