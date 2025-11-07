package com.ramon.loans.infrastructure.web.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = EnumValueConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValue {

    Class<? extends Enum<?>> enumClass();

    String message() default "Value must be one of {enumClass} values";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
