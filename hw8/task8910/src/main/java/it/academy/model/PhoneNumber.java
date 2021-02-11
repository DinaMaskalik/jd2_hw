package it.academy.model;

import it.academy.utils.annotation.PhoneAnnotation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
@PhoneAnnotation
public class PhoneNumber implements IPhoneNumber {

    @Value("1")
    private Integer phoneId;

    @Value("+375336649290")
    private String phoneNumber;

    @Value("12")
    private Double balance;
}
