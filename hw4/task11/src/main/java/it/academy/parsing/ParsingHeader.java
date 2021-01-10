package it.academy.parsing;

public class ParsingHeader {

    public String getBrowser(String info) {
        return info.substring(info.indexOf("-") + 1, info.length());
    }
}
