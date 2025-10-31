package com.ramon.loans.infrastructure.web.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoanAssessmentDTO {

    private String customer;
    private List<LoanDTO> loans;

}
