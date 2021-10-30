package model.service.common;

public class Validator {

    public static String validateIdCard(String idCard) {
        String message = null;
        String regex = "(^\\d{9}$)|(^\\d{12}$)";
        if (!idCard.matches(regex)) {
            message = "Invalid id card format!";
        }
        return message;
    }

    public static String validatePhone(String phone) {
        String message = null;
        String regex = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\(\\+84\\)90)\\d{7}$)|(^(\\(\\+84\\)91)\\d{7}$)";
        if (!phone.matches(regex)) {
            message = "Invalid phone number format!";
        }
        return message;
    }

    public static String validateEmail(String email) {
        String message = null;
        String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if (!email.matches(regex)) {
            message = "Invalid email format!";
        }
        return message;
    }

    public static String validateDate(String date) {
        String message = null;
        String regex = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
        if (!date.matches(regex)) {
            message = "Invalid date format!";
        }
        return message;
    }

    public static String validateInteger(double number) {
        String message = null;
        if (number < 0) {
            message = "Number must be greater than 0!";
        }
        return message;
    }
}
