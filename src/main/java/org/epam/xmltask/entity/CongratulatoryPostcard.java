package org.epam.xmltask.entity;

import java.time.LocalDate;

public class CongratulatoryPostcard extends Postcard {
    private String holiday;

    public CongratulatoryPostcard(String theme, boolean isSent, String country, LocalDate releaseDate,
                                  String author, String valuation, String id, String website, String holiday) {

        super(theme, isSent, country, releaseDate, author, valuation, id, website);
        this.holiday = holiday;
    }

    public CongratulatoryPostcard(String theme, boolean isSent, String country, LocalDate releaseDate,
                                  String author, String valuation, String id, String holiday) {

        super(theme, isSent, country, releaseDate, author, valuation, id);
        this.holiday = holiday;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        CongratulatoryPostcard congratulatoryPostcard = (CongratulatoryPostcard) obj;

        boolean flag = super.equals(congratulatoryPostcard)
                && (this.holiday != null && this.holiday.equals(congratulatoryPostcard.holiday));

        return flag;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += customStringHashCode(holiday);

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString());
        stringBuilder.append(" ,").append(holiday);

        return stringBuilder.toString();
    }
}
