package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
