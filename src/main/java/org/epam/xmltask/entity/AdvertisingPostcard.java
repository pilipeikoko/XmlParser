package org.epam.xmltask.entity;

import java.time.LocalDate;

public class AdvertisingPostcard extends Postcard {
    private String company;
    private LocalDate expirationDate;

    public AdvertisingPostcard(String theme, boolean isSent, String country, LocalDate releaseDate,
                               String author, String valuation, String id, String website, String company,
                               LocalDate expirationDate) {

        super(theme, isSent, country, releaseDate, author, valuation, id, website);
        this.company = company;
        this.expirationDate = expirationDate;
    }

    public AdvertisingPostcard(String theme, boolean isSent, String country, LocalDate releaseDate,
                               String author, String valuation, String id, String company,
                               LocalDate expirationDate) {

        super(theme, isSent, country, releaseDate, author, valuation, id);
        this.company = company;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AdvertisingPostcard congratulatoryPostcard = (AdvertisingPostcard) obj;

        boolean flag = super.equals(congratulatoryPostcard)
                && (this.company != null && this.company.equals(congratulatoryPostcard.company))
                && (this.expirationDate != null && this.expirationDate.equals(congratulatoryPostcard.expirationDate));

        return flag;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += customStringHashCode(company);
        result += expirationDate == null ? 0 : expirationDate.hashCode();

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString());
        stringBuilder.append(" ,").append(company).append(" ,");
        stringBuilder.append(expirationDate.toString());

        return stringBuilder.toString();
    }
}
