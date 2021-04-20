package org.epam.xmltask.parser;

import org.epam.xmltask.entity.Postcard;
import org.epam.xmltask.exception.CustomXmlParserException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ParserTest {

    @Test
    public void postcardSaxParserTest() throws CustomXmlParserException {
        String path = "data/oldCards.xml";

        PostcardParser postcardParser = new PostcardSaxParser();

        postcardParser.createListOfPostcards(path);
        List<Postcard> listOfPostcards = postcardParser.getListOfPostcards();

        int expectedSize = 16;
        int actualSize = listOfPostcards.size();

        Assert.assertEquals(expectedSize, actualSize);

    }
    @Test
    public void postcardStaxParserTest() throws CustomXmlParserException {
        String path = "data/oldCards.xml";

        PostcardParser postcardParser = new PostcardStaxParser();

        postcardParser.createListOfPostcards(path);
        List<Postcard> listOfPostcards = postcardParser.getListOfPostcards();

        int expectedSize = 16;
        int actualSize = listOfPostcards.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void postcardDomParserTest() throws CustomXmlParserException {
        String path = "data/oldCards.xml";

        PostcardParser postcardParser = new PostcardDomParser();

        postcardParser.createListOfPostcards(path);
        List<Postcard> listOfPostcards = postcardParser.getListOfPostcards();

        int expectedSize = 16;
        int actualSize = listOfPostcards.size();

        Assert.assertEquals(expectedSize, actualSize);
    }
}
