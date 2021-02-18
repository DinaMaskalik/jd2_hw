package it.academy.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Passport {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Access(AccessType.FIELD)
    private String passportId;

    @Column
    @Access(AccessType.FIELD)
    private String passportSeries="QW";


    private String passportNumber="1234567";

    @Column
    @Access(AccessType.PROPERTY)
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Column
    @Transient
    private String visaType;
}
