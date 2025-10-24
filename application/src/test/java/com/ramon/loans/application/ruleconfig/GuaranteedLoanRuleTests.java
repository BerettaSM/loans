package com.ramon.loans.application.ruleconfig;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ramon.loans.application.factories.LoanRuleFactory;
import com.ramon.loans.core.domain.enums.State;
import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.domain.rule.LoanRule;
import com.ramon.loans.coretest.factories.CustomerFactory;

public class GuaranteedLoanRuleTests {
    
    private static double lowerLoanThreshold;
    private static double belowLowerLoanThreshold;
    private static double aboveLowerLoanThreshold;

    private static double higherLoanThreshold;
    private static double aboveHigherLoanThreshold;

    private static int ageAtThreshold;
    private static int ageBelowThreshold;

    private static LoanRule guaranteedLoanRule;

    @BeforeEach
    public void initialization() {
        lowerLoanThreshold = 3000.0;
        belowLowerLoanThreshold = lowerLoanThreshold - 0.1;
        aboveLowerLoanThreshold = lowerLoanThreshold + 0.1;

        higherLoanThreshold = 5000.0;
        aboveHigherLoanThreshold = higherLoanThreshold + 0.1;

        ageAtThreshold = 30;
        ageBelowThreshold = ageAtThreshold - 1;

        guaranteedLoanRule = LoanRuleFactory.createGuaranteedLoanRule();
    }
    
    @Test
    public void isEligibleShouldReturnTrueWhenIncomeIsAtThreshold() {
        Customer candidate = CustomerFactory.withIncome(lowerLoanThreshold);

        assertTrue(guaranteedLoanRule.isEligible(candidate));
    }

    @Test
    public void isEligibleShouldReturnTrueWhenIncomeIsBelowThreshold() {
        Customer candidate = CustomerFactory.withIncome(belowLowerLoanThreshold);

        assertTrue(guaranteedLoanRule.isEligible(candidate));
    }

    @Test
    public void isEligibleShouldReturnFalseWhenIncomeIsAboveThreshold() {
        Customer candidate = CustomerFactory.withIncome(aboveLowerLoanThreshold);

        assertFalse(guaranteedLoanRule.isEligible(candidate));
    }

    @Test
    public void isEligibleShouldReturnTrueWhenIncomeAboveLowerThresholdAndCustomerBelow30AndLocatedAtSP() {
        Customer candidate = CustomerFactory.with(
            aboveLowerLoanThreshold,
            ageBelowThreshold,
            State.SP);
        
        assertTrue(guaranteedLoanRule.isEligible(candidate));
    }

    @Test
    public void isEligibleShouldReturnTrueWhenIncomeAtHigherThresholdAndCustomerBelow30AndLocatedAtSP() {
        Customer candidate = CustomerFactory.with(
            higherLoanThreshold,
            ageBelowThreshold,
            State.SP);
        
        assertTrue(guaranteedLoanRule.isEligible(candidate));
    }

    @Test
    public void isEligibleShouldReturnFalseWhenIncomeWithinThresholdAndCustomerAt30AndLocatedAtSP() {
        Customer candidate = CustomerFactory.with(
            aboveLowerLoanThreshold,
            ageAtThreshold,
            State.SP);

        assertFalse(guaranteedLoanRule.isEligible(candidate));
    }

    @Test
    public void isEligibleShouldReturnFalseWhenIncomeWithinThresholdAndCustomerBelow30AndNotLocatedAtSP() {
        Customer candidate = CustomerFactory.with(
            aboveLowerLoanThreshold,
            ageBelowThreshold,
            State.AL);

        assertFalse(guaranteedLoanRule.isEligible(candidate));
    }

    @Test
    public void isEligibleShouldReturnFalseWhenIncomeWithinThresholdAndCustomerAt30AndNotLocatedAtSP() {
        Customer candidate = CustomerFactory.with(
            aboveLowerLoanThreshold,
            ageAtThreshold,
            State.AL);

        assertFalse(guaranteedLoanRule.isEligible(candidate));
    }

        @Test
    public void isEligibleShouldReturnFalseWhenIncomeAboveThresholdAndCustomerBelow30AndLocatedAtSP() {
        Customer candidate = CustomerFactory.with(
            aboveHigherLoanThreshold,
            ageBelowThreshold,
            State.SP);

        assertFalse(guaranteedLoanRule.isEligible(candidate));
    }

}
