package it.academy.data;

public class ValidateNewInformation {

    public boolean verifyNumber(String number){
        return number.matches("\\d+");
    }

    public boolean verifyDouble(String pay){

        return pay.matches("\\d+\\.\\d{1,2}");
    }

    public boolean verifyDate(String date){
        return date.matches("\\d{4}\\-\\d{1,2}\\-\\d{1,2}");
    }
}
