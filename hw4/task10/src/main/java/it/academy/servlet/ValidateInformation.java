package it.academy.servlet;

public class ValidateInformation {

    public boolean verifyName(String name) {

        return name.matches("[a-zA-Z]+");
    }

    public boolean verifyPhoneNumber(String phoneNumber) {
        if (!"".equals(phoneNumber))
            return phoneNumber.matches("\\+\\d{12}");
        return true;
    }

    public boolean verifyEmail(String email) {
        if (!"".equals(email))
            return email.matches("[a-zA-Z0-9]+@[a-z]+\\.[a-z]{2,4}");
        return true;
    }
}
