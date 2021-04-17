package org.epam.xmltask.entity;

import java.time.LocalDate;

public class Postcard {
    private static final String DEFAULT_WEBSITE = "defaultwebsite.com";

    private String theme;
    private String country;
    private String author;
    private String valuation;

    private boolean isSent;
    private LocalDate releaseDate;

    private String id;
    private String website;

    public Postcard(){

    }

    public Postcard(String theme, String country, String author, String valuation, boolean isSent
            , LocalDate releaseDate, String id, String website) {
        this.theme = theme;
        this.country = country;
        this.author = author;
        this.valuation = valuation;
        this.isSent = isSent;
        this.releaseDate = releaseDate;
        this.id = id;
        this.website = website;
    }

    public Postcard(String theme, String country, String author, String valuation, boolean isSent
            , LocalDate releaseDate, String id) {
        this.theme = theme;
        this.country = country;
        this.author = author;
        this.valuation = valuation;
        this.isSent = isSent;
        this.releaseDate = releaseDate;
        this.id = id;
        this.website = DEFAULT_WEBSITE;
    }

    public String getTheme() {
        return theme;
    }

    public String getCountry() {
        return country;
    }

    public String getAuthor() {
        return author;
    }

    public String getValuation() {
        return valuation;
    }

    public boolean isSent() {
        return isSent;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getId() {
        return id;
    }

    public String getWebsite() {
        return website;
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

    protected int customStringHashCode(String string) {
        int result;
        if (string == null) {
            result = 0;
        } else {
            result = string.hashCode();
        }
        return result;
    }


}
