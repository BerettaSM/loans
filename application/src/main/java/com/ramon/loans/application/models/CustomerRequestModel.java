package com.ramon.loans.application.models;

import java.math.BigDecimal;

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
    private String location;

}
