package org.epam.xmltask.validator;

import org.epam.xmltask.entity.OldCardsAttribute;
import org.epam.xmltask.entity.OldCardsElement;
import org.epam.xmltask.entity.OldCardsType;

public class OldCardsEnumValidator {

    public static boolean isPostcardTypeCorrect(String value) {
        boolean flag = false;

        for (OldCardsType type : OldCardsType.values()) {
            String tempValue = type.name().toLowerCase().replaceAll("_", "-");
            if (tempValue.equals(value)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean isPostcardElementCorrect(String value) {
        boolean flag = false;

        for (OldCardsElement elements : OldCardsElement.values()) {
            String tempValue = elements.name().toLowerCase().replaceAll("_", "-");

            if (tempValue.equals(value)) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static boolean isPostcardAttributeCorrect(String value) {
        boolean flag = false;

        for (OldCardsAttribute attributes : OldCardsAttribute.values()) {
            String tempValue = attributes.name().toLowerCase().replaceAll("_", "-");

            if (tempValue.equals(value)) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
