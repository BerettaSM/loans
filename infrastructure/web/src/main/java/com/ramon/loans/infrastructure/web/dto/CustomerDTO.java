package com.ramon.loans.infrastructure.web.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CustomerDTO {

    private String name;
    private String cpf;
    private Integer age;
    private BigDecimal income;
    private String location;

}
