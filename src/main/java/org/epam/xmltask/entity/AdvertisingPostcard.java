package org.epam.xmltask.entity;

import java.time.LocalDate;

public class AdvertisingPostcard extends Postcard {
    private String company;
    private LocalDate expirationDate;

    public AdvertisingPostcard(String theme, String country, String author, String valuation, boolean isSent, LocalDate releaseDate, String id, String website, String company, LocalDate expirationDate) {
        super(theme, country, author, valuation, isSent, releaseDate, id, website);
        this.company = company;
        this.expirationDate = expirationDate;
    }

    public AdvertisingPostcard(String theme, String country, String author, String valuation, boolean isSent, LocalDate releaseDate, String id, String company, LocalDate expirationDate) {
        super(theme, country, author, valuation, isSent, releaseDate, id);
        this.company = company;
        this.expirationDate = expirationDate;
    }

    public String getCompany() {
        return company;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
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

        //todo might be wrong
        boolean flag = super.equals(congratulatoryPostcard)
                && (this.company != null && this.company.equals(congratulatoryPostcard.company))
                && (this.expirationDate != null && this.expirationDate.equals(congratulatoryPostcard.expirationDate));

        return flag;
    }

    @Override
    public int hashCode() {
        //todo might be wrong as well
        int result = super.hashCode();
        result += customStringHashCode(company);
        result += expirationDate == null ? 0 : expirationDate.hashCode();

        return result;
    }

    @Override
    //todo might be wrong as well
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString());
        stringBuilder.append(" ,").append(company).append(" ,");
        stringBuilder.append(expirationDate.toString());

        return stringBuilder.toString();
    }
}
