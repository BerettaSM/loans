package com.ramon.loans.infrastructure.web.validation.annotations;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValueConstraintValidator implements ConstraintValidator<EnumValue, String> {

    private Set<String> acceptedValues;

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        acceptedValues = Stream.of(constraintAnnotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return acceptedValues.contains(value);
    }

}
