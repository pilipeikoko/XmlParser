package org.epam.xmltask.entity;

import java.time.LocalDate;

public class CongratulatoryPostcard extends Postcard{
    private String holiday;

    public CongratulatoryPostcard(String theme, String country, String author, String valuation, boolean isSent, LocalDate releaseDate, String id, String website,String holiday) {

        super(theme, country, author, valuation, isSent, releaseDate, id, website);
        this.holiday = holiday;
    }

    public CongratulatoryPostcard(String theme, String country, String author, String valuation, boolean isSent, LocalDate releaseDate, String id, String holiday) {
        super(theme, country, author, valuation, isSent, releaseDate, id);
        this.holiday = holiday;
    }

    public String getHoliday() {
        return holiday;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        CongratulatoryPostcard congratulatoryPostcard = (CongratulatoryPostcard) obj;

        //todo might be wrong
        boolean flag = super.equals(congratulatoryPostcard)
                && (this.holiday != null && this.holiday.equals(congratulatoryPostcard.holiday));

        return flag;
    }

    @Override
    public int hashCode(){
        //todo might be wrong as well
        int result = super.hashCode();
        result += customStringHashCode(holiday);

        return result;
    }

    @Override
    //todo might be wrong as well
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString());
        stringBuilder.append(" ,").append(holiday);

        return stringBuilder.toString();
    }
}
