package com.ramon.loans.application.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoanResponseModel {
    
    private String type;
    private Integer interestRate;

}
