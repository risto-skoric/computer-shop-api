package risto.computer.shop.api.util;

public class Validations {

    public static boolean isFiledEmpty (String field) {
        return field == null || field.equals("") || field.trim().length() == 0;
    }
}