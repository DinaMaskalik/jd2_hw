package it.academy.model;

import com.sun.istack.Nullable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Person{

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

}
