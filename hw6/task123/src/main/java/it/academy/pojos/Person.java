package it.academy.pojos;

import com.sun.istack.Nullable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
//@Table(name = "T_PERSON")
public class Person implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String personId;

    @Column
    private Integer age;

    @Column
    private String name;

    @Column
    private String surname;

    @Embedded
    @Nullable
    private Address address;

}
