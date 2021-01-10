package it.academy.servlet;

public class ValidateInformation {

    public boolean verifyName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public boolean verifyPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\+\\d{12}");
    }

    public boolean verifyEmail(String email){
        return email.matches("[a-zA-Z[\\.]]+\\@[a-z]+\\.[a-z]");
    }
}
