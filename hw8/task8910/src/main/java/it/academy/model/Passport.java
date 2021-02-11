package it.academy.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Passport {

    private String passportId;

    private String passportSeries;

    private String passportNumber;

    private String visaType;
}
