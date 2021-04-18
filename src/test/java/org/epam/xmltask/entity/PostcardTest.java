package org.epam.xmltask.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class PostcardTest {

    @Test
    public void postcardTest(){
        String theme = "important";
        String country = "BELARUS";
        String author = "Pushkin";
        String valuation = "historical";
        boolean isSent = true;
        LocalDate releaseDate = LocalDate.parse("2021-12-12");
        String id = "id5";
        String website = "www.test.com";

        Postcard postcard = new Postcard(theme,country,author,valuation,isSent,releaseDate,id,website);

        String expectedValue = "id: id5, website: www.test.com, theme: important, country: BELARUS, author: Pushkin," +
                " valuation: historical, isSent: true, releaseDate: 2021-12-12";
        String actualValue = postcard.toString();


        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test
    public void congratulatoryPostcardTest(){
        String theme = "important";
        String country = "BELARUS";
        String author = "Pushkin";
        String valuation = "historical";
        boolean isSent = true;
        LocalDate releaseDate = LocalDate.parse("2021-12-12");
        String id = "id5";
        String website = "www.test.com";
        String holiday = "Christmas";

        Postcard congratulatoryPostcard = new CongratulatoryPostcard(theme,country,author,valuation,
                isSent,releaseDate,id,website,holiday);


        String expectedValue = new StringBuilder("id: id5, website: www.test.com, theme: important, country: BELARUS," +
                " author: Pushkin, valuation: historical, isSent: true, releaseDate: 2021-12-12 ,Christmas").toString();
        String actualValue = congratulatoryPostcard.toString();


        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test
    public void advertisingPostcardTest(){
        String theme = "important";
        String country = "BELARUS";
        String author = "Pushkin";
        String valuation = "historical";
        boolean isSent = true;
        LocalDate releaseDate = LocalDate.parse("2021-12-12");
        String id = "id5";
        String website = "www.test.com";
        String company = "epam:)";
        LocalDate expirationDate = LocalDate.parse("2022-10-10");

        Postcard advertisingPostcard = new AdvertisingPostcard(theme,country,author,valuation,
                isSent,releaseDate,id,website,company,expirationDate);

        String expectedValue = new StringBuilder("id: id5, website: www.test.com, theme: important, country: BELARUS," +
                " author: Pushkin, valuation: historical, isSent: true, releaseDate: 2021-12-12 ,epam:) ,2022-10-10")
                .toString();
        String actualValue = advertisingPostcard.toString();

        Assert.assertEquals(actualValue,expectedValue);
    }
}
