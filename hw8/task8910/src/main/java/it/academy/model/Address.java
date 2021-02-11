package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Value("Gikalo")
    private String street;

    @Value("Minsk")
    private String city;

    @Value("1234567")
    private String postalCode;

}
