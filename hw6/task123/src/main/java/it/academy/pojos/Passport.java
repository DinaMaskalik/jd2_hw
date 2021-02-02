package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Passport {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Access(AccessType.PROPERTY)
    private String passportId;

    @Column
    @Access(AccessType.FIELD)
    private String passportSeries="QW";

    @Column
    @Access(AccessType.PROPERTY)
    private String passportNumber="1234567";

    @Column
    @Transient
    private String visaType;
}
