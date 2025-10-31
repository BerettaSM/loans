package com.ramon.loans.infrastructure.web.config.beans;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ramon.loans.application.mappers.CustomerMapper;
import com.ramon.loans.application.mappers.LoanAssessmentMapper;
import com.ramon.loans.application.ports.in.AssessLoansInputPort;
import com.ramon.loans.application.usecases.AssessLoansUseCase;
import com.ramon.loans.core.domain.policies.LoanEligibilityPolicy;
import com.ramon.loans.core.domain.rule.LoanRule;

@SuppressWarnings("unused")
@Configuration
public class UseCaseConfig {

    @Bean
    AssessLoansInputPort assessLoansInputPort(
            CustomerMapper customerMapper,
            LoanAssessmentMapper loanAssessmentMapper,
            LoanEligibilityPolicy loanEligibilityPolicy,
            List<LoanRule> loanRules) {
        return new AssessLoansUseCase(customerMapper, loanAssessmentMapper, loanEligibilityPolicy, loanRules);
    }

}
