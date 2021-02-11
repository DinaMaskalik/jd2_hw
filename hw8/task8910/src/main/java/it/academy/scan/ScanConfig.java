package it.academy.scan;

import it.academy.utils.annotation.PhoneAnnotation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = "it.academy", includeFilters =
            @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = PhoneAnnotation.class))
public class ScanConfig {

}
