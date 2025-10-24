package com.ramon.loans.application.ruleconfig;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ramon.loans.application.factories.LoanRuleFactory;
import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.domain.rule.LoanRule;
import com.ramon.loans.coretest.factories.CustomerFactory;

public class ConsignmentLoanRuleTests {
    
    private static double loanThreshold;
    private static double belowLoanThreshold;
    private static double aboveLoanThreshold;

    private static LoanRule consignmentLoanRule;

    @BeforeEach
    public void initialization() {
        loanThreshold = 5000.0;
        belowLoanThreshold = loanThreshold - 0.1;
        aboveLoanThreshold = loanThreshold + 0.1;

        consignmentLoanRule = LoanRuleFactory.createConsignmentLoanRule();
    }

    @Test
    public void isEligibleShouldReturnFalseWhenIncomeBelowThreshold() {
        Customer candidate = CustomerFactory.withIncome(belowLoanThreshold);

        assertFalse(consignmentLoanRule.isEligible(candidate));
    }

    @Test
    public void isEligibleShouldReturnTrueWhenIncomeAtThreshold() {
        Customer candidate = CustomerFactory.withIncome(loanThreshold);

        assertTrue(consignmentLoanRule.isEligible(candidate));
    }

    @Test
    public void isEligibleShouldReturnTrueWhenIncomeAboveThreshold() {
        Customer candidate = CustomerFactory.withIncome(aboveLoanThreshold);

        assertTrue(consignmentLoanRule.isEligible(candidate));
    }
    
}
