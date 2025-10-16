package com.ramon.loans.core.domain.policies;

import java.util.List;

import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.domain.models.Loan;
import com.ramon.loans.core.domain.rule.LoanRule;

public class LoanEligibilityPolicy {
    
    public List<Loan> assessEligibleLoans(Customer customer, List<LoanRule> loanRules) {
        return loanRules.stream()
            .filter(rule -> rule.isEligible(customer))
            .map(LoanRule::getLoan)
            .toList();
    }

}
