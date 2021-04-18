package org.epam.xmltask.validator;

public class OldCardsAttributesValidator {
    private final static String ID_PATTERN = "\\w{1,20}";
    private final static String WEBSITE_PATTERN = "(https?://)?([\\w\\d]+\\.)?[\\w\\d]+\\.\\w+/?.+";

    public static boolean isIdCorrect(String id){
        boolean flag = id.matches(ID_PATTERN);

        return flag;
    }

    public static boolean isWebsiteCorrect(String website){
        boolean flag = website.matches(WEBSITE_PATTERN);

        return flag;
    }
}
