package com.ramon.loans.infrastructure.web.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ramon.loans.application.ruleconfig.ConsignmentLoanRule;
import com.ramon.loans.application.ruleconfig.GuaranteedLoanRule;
import com.ramon.loans.application.ruleconfig.PersonalLoanRule;
import com.ramon.loans.core.domain.policies.LoanEligibilityPolicy;
import com.ramon.loans.core.domain.rule.LoanRule;

@SuppressWarnings("unused")
@Configuration
public class LoanConfig {

    @Bean
    LoanEligibilityPolicy loanEligibilityPolicy() {
        return new LoanEligibilityPolicy();
    }

    @Bean
    LoanRule personalLoanRule() {
        return new PersonalLoanRule();
    }

    @Bean
    LoanRule guaranteedLoanRule() {
        return new GuaranteedLoanRule();
    }

    @Bean
    LoanRule consignmentLoanRule() {
        return new ConsignmentLoanRule();
    }

}
