package com.ramon.loans.infrastructure.web.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.br.CPF;

import com.ramon.loans.core.domain.enums.State;
import com.ramon.loans.infrastructure.web.validation.annotations.EnumValue;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CustomerDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 4, message = "Name must have at least 4 characters")
    private String name;

    @NotBlank(message = "CPF is required")
    @CPF(message = "Must be a valid CPF")
    private String cpf;

    @NotNull(message = "Age is required")
    @Positive(message = "Age must be a positive value")
    private Integer age;

    @NotNull(message = "Income is required")
    @Positive(message = "Income must be a positive value")
    private BigDecimal income;

    @NotNull(message = "Location is required")
    @EnumValue(enumClass = State.class, message = "Location must be a valid state")
    private String location;

}
