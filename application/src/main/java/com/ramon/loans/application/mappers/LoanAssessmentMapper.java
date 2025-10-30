package com.ramon.loans.application.mappers;

import java.util.List;

import com.ramon.loans.application.models.LoanAssessmentResponseModel;
import com.ramon.loans.application.models.LoanResponseModel;
import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.domain.models.Loan;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoanAssessmentMapper {

    private final LoanMapper loanMapper;
    
    public LoanAssessmentResponseModel toResponseModel(Customer customer, List<Loan> loans) {
        LoanAssessmentResponseModel response = new LoanAssessmentResponseModel();
        List<LoanResponseModel> loanResponses = loans.stream().map(loanMapper::toResponseModel).toList();
        response.setLoans(loanResponses);
        response.setCustomer(customer.getName());
        return response;
    }

}
