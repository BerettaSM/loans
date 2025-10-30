package com.ramon.loans.application.usecases;

import java.util.List;

import com.ramon.loans.application.mappers.CustomerMapper;
import com.ramon.loans.application.mappers.LoanAssessmentMapper;
import com.ramon.loans.application.models.CustomerRequestModel;
import com.ramon.loans.application.models.LoanAssessmentResponseModel;
import com.ramon.loans.application.ports.in.AssessLoansInputPort;
import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.domain.models.Loan;
import com.ramon.loans.core.domain.policies.LoanEligibilityPolicy;
import com.ramon.loans.core.domain.rule.LoanRule;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssessLoansUseCase implements AssessLoansInputPort {

    private final CustomerMapper customerMapper;
    private final LoanAssessmentMapper loanAssessmentMapper;

    private final LoanEligibilityPolicy policy;

    private final List<LoanRule> loanRules;

    @Override
    public LoanAssessmentResponseModel execute(CustomerRequestModel requestModel) {
        Customer customer = customerMapper.toDomain(requestModel);

        List<Loan> loans = policy.assessEligibleLoans(customer, loanRules);

        return loanAssessmentMapper.toResponseModel(customer, loans);
    }
    
}
