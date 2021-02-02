package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String postalCode;

}
