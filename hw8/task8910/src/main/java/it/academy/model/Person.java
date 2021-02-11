package it.academy.model;

import it.academy.utils.annotation.PhoneAnnotation;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Person {

    private String personId;

    private Integer age;

    private String name;

    private String surname;

    private Address address;

    @Autowired(required = false)
    @PhoneAnnotation
    private IPhoneNumber number;
}
