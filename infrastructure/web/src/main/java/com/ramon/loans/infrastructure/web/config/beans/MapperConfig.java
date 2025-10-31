package com.ramon.loans.infrastructure.web.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ramon.loans.application.mappers.CustomerMapper;
import com.ramon.loans.application.mappers.LoanAssessmentMapper;
import com.ramon.loans.application.mappers.LoanMapper;

@SuppressWarnings("unused")
@Configuration
public class MapperConfig {

    @Bean
    CustomerMapper customerDomainMapper() {
        return new CustomerMapper();
    }

    @Bean
    LoanMapper loanDomainMapper() {
        return new LoanMapper();
    }

    @Bean
    LoanAssessmentMapper loanAssessmentMapper(LoanMapper loanMapper) {
        return new LoanAssessmentMapper(loanMapper);
    }

}
