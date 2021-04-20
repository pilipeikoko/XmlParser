package org.epam.xmltask.validator;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidatorTest {

    @DataProvider(name = "idTestData")
    public Object[][] idTestData() {
        return new Object[][]{
                {"p1", true},
                {"", false},
                {"someId", true},
                {"SentenceWithLengthMoreThan20", false},
        };
    }

    @DataProvider(name = "WebsiteTestProvider")
    public Object[][] websiteTestData() {
        return new Object[][]{
                {"https://test.com", true},
                {"http://test.com", true},
                {"www.test.ru", true},
                {"test.com", true},
                {".test.com",false}
        };
    }


    @Test(dataProvider = "idTestData")
    public void idTest(String id, boolean expectedResult){

        boolean actualResult = OldCardsAttributesValidator.isIdCorrect(id);

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(dataProvider = "WebsiteTestProvider")
    public void websiteTest(String website, boolean expectedResult){

        boolean actualResult = OldCardsAttributesValidator.isWebsiteCorrect(website);

        Assert.assertEquals(expectedResult,actualResult);
    }
}
