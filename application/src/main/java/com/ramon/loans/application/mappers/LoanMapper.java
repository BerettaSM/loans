package com.ramon.loans.application.mappers;

import com.ramon.loans.application.models.LoanResponseModel;
import com.ramon.loans.core.domain.models.Loan;

public class LoanMapper {
    
    public LoanResponseModel toResponseModel(Loan loan) {
        LoanResponseModel response = new LoanResponseModel();
        response.setType(loan.getType().toString());
        response.setInterestRate(loan.getInterestRate());
        return response;
    }

}
