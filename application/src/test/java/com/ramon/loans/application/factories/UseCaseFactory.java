package com.ramon.loans.application.factories;

import java.util.List;

import com.ramon.loans.application.mappers.CustomerMapper;
import com.ramon.loans.application.mappers.LoanAssessmentMapper;
import com.ramon.loans.application.mappers.LoanMapper;
import com.ramon.loans.application.ruleconfig.ConsignmentLoanRule;
import com.ramon.loans.application.ruleconfig.GuaranteedLoanRule;
import com.ramon.loans.application.ruleconfig.PersonalLoanRule;
import com.ramon.loans.application.usecases.AssessLoansUseCase;
import com.ramon.loans.core.domain.policies.LoanEligibilityPolicy;
import com.ramon.loans.core.domain.rule.LoanRule;

public class UseCaseFactory {

    public static final AssessLoansUseCase createAssessLoansUseCase(LoanEligibilityPolicy policy) {
        CustomerMapper customerMapper = new CustomerMapper();
        LoanMapper loanMapper = new LoanMapper();
        LoanAssessmentMapper loanAssessmentMapper = new LoanAssessmentMapper(loanMapper);
        List<LoanRule> loanRules = List.of(
                new PersonalLoanRule(),
                new GuaranteedLoanRule(),
                new ConsignmentLoanRule());
        return new AssessLoansUseCase(customerMapper, loanAssessmentMapper, policy, loanRules);
    }

    public static final AssessLoansUseCase createAssessLoansUseCase() {
        LoanEligibilityPolicy policy = new LoanEligibilityPolicy();
        return createAssessLoansUseCase(policy);
    }

}
