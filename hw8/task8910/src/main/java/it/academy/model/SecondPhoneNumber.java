package it.academy.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component("secondPhone")
@Data
public class SecondPhoneNumber implements IPhoneNumber {

    private String phoneNumber;
}
