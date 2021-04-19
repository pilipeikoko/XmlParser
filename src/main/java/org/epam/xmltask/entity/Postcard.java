package org.epam.xmltask.entity;

import java.time.LocalDate;

//todo add more xml elements
//todo loggers
//todo main

public class Postcard {
    private static final String DEFAULT_WEBSITE = "defaultwebsite.com";

    private String theme;
    private boolean isSent;
    private String country;
    private LocalDate releaseDate;
    private String author;
    private String valuation;

    private String id;
    private String website;

    public Postcard() {

    }

    public Postcard(String theme, boolean isSent, String country, LocalDate releaseDate,
                    String author, String valuation, String id, String website) {
        this.theme = theme;
        this.isSent = isSent;
        this.country = country;
        this.releaseDate = releaseDate;
        this.author = author;
        this.valuation = valuation;
        this.id = id;
        this.website = website;
    }

    public Postcard(String theme, boolean isSent, String country, LocalDate releaseDate,
                    String author, String valuation, String id) {
        this.theme = theme;
        this.isSent = isSent;
        this.country = country;
        this.releaseDate = releaseDate;
        this.author = author;
        this.valuation = valuation;
        this.id = id;
        this.website = DEFAULT_WEBSITE;
    }

    protected int customStringHashCode(String string) {
        int result;
        if (string == null) {
            result = 0;
        } else {
            result = string.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Postcard postcard = (Postcard) obj;

        boolean flag = (this.author != null && this.author.equals(postcard.author))
                && (this.country != null && this.country.equals(postcard.country))
                && (this.theme != null && this.theme.equals(postcard.theme))
                && (this.valuation != null && this.valuation.equals(postcard.valuation))
                && (this.releaseDate != null && this.releaseDate.equals(postcard.releaseDate))
                && (this.id != null && this.id.equals(postcard.id))
                && (this.website != null && this.website.equals(postcard.website))
                && (this.isSent == postcard.isSent);

        return flag;
    }

    @Override
    public int hashCode() {

        int result = customStringHashCode(theme);
        result += customStringHashCode(country);
        result += customStringHashCode(author);
        result += customStringHashCode(valuation);
        result += customStringHashCode(id);
        result += customStringHashCode(website);
        result += isSent ? 1 : 0;
        result += releaseDate == null ? 1 : releaseDate.hashCode();

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("id: ").append(id).append(",");
        stringBuilder.append(" website: ").append(website).append(",");
        stringBuilder.append(" theme: ").append(theme).append(",");
        stringBuilder.append(" country: ").append(country).append(",");
        stringBuilder.append(" author: ").append(author).append(",");
        stringBuilder.append(" valuation: ").append(valuation).append(",");
        stringBuilder.append(" isSent: ").append(isSent).append(",");
        stringBuilder.append(" releaseDate: ").append(releaseDate);

        return stringBuilder.toString();
    }

}
