package it.academy.pojos;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class PhoneNumber {

    @Id
    @GeneratedValue(generator = "gen-increment")
    @GenericGenerator(name = "gen-increment", strategy = "increment")
    private Integer phoneId;

    @Column
    private String phoneNumber;

    @Column
    private Double balance;
}
