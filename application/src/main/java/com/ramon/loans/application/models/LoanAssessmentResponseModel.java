package com.ramon.loans.application.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoanAssessmentResponseModel {
    
    private String customer;
    private List<LoanResponseModel> loans;

}
