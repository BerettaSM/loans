package com.ramon.loans.application.models;

import java.math.BigDecimal;

import com.ramon.loans.core.domain.enums.State;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CustomerRequestModel {

    private String name;
    private String cpf;
    private Integer age;
    private BigDecimal income;
    private State location;

}
