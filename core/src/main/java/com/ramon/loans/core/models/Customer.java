package com.ramon.loans.core.models;

import java.math.BigDecimal;

import com.ramon.loans.core.enums.State;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Customer {

    private String name;
    private String cpf;
    private Integer age;
    private BigDecimal income;
    private State location;

    public Customer(String name, String cpf, Integer age, BigDecimal income, String location) {
        this(name, cpf, age, income, State.valueOf(location));
    }

}
