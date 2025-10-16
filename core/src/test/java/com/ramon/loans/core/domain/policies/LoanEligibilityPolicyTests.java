package com.ramon.loans.core.domain.policies;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.domain.models.Loan;
import com.ramon.loans.core.domain.rule.LoanRule;
import com.ramon.loans.core.factories.CustomerFactory;
import com.ramon.loans.core.factories.LoanFactory;

public class LoanEligibilityPolicyTests {

    private LoanEligibilityPolicy policy;

    private Customer customer;

    private LoanRule trueLoanRule;
    private LoanRule falseLoanRule;

    @BeforeEach
    public void initialization() {
        policy = LoanFactory.createLoanEligibilityPolicy();

        customer = CustomerFactory.createCustomer();

        trueLoanRule = LoanFactory.createTrueLoanRule();
        falseLoanRule = LoanFactory.createFalseLoanRule();
    }

    @Test
    public void assessEligibleLoansShouldReturnLoanWhenCustomerEligible() {
        List<Loan> eligibleLoans = policy.assessEligibleLoans(customer, List.of(trueLoanRule));

        assertTrue(eligibleLoans.contains(trueLoanRule.getLoan()));
    }

    @Test
    public void assessEligibleLoansShouldNotReturnLoanWhenCustomerNotEligible() {
        List<Loan> eligibleLoans = policy.assessEligibleLoans(customer, List.of(falseLoanRule));

        assertFalse(eligibleLoans.contains(falseLoanRule.getLoan()));
    }

    @Test
    public void assessEligibleLoansShouldReturnEmptyListWhenGivenEmptyRuleList() {
        List<Loan> eligibleLoans = policy.assessEligibleLoans(customer, List.of());

        assertTrue(eligibleLoans.isEmpty());
    }

    @Test
    public void assessEligibleLoansShouldReturnOnlyEligibleLoansForCustomer() {
        List<Loan> eligibleLoans = policy.assessEligibleLoans(customer, List.of(trueLoanRule, falseLoanRule));

        assertTrue(eligibleLoans.contains(trueLoanRule.getLoan()));
        assertFalse(eligibleLoans.contains(falseLoanRule.getLoan()));
    }

    @Test
    public void assessEligibleLoansShouldReturnZeroLoansWhenCustomerEligibleForZeroLoans() {
        int expectedTotalLoans = 0;

        List<Loan> eligibleLoans = policy.assessEligibleLoans(
                customer,
                List.of(falseLoanRule, falseLoanRule, falseLoanRule));

        assertEquals(expectedTotalLoans, eligibleLoans.size());
    }

    @Test
    public void assessEligibleLoansShouldReturnOneLoanWhenCustomerEligibleForOneLoan() {
        int expectedTotalLoans = 1;

        List<Loan> eligibleLoans = policy.assessEligibleLoans(
                customer,
                List.of(falseLoanRule, trueLoanRule, falseLoanRule));

        assertEquals(expectedTotalLoans, eligibleLoans.size());
    }

    @Test
    public void assessEligibleLoansShouldReturnTwoLoansWhenCustomerEligibleForTwoLoans() {
        int expectedTotalLoans = 2;

        List<Loan> eligibleLoans = policy.assessEligibleLoans(
                customer,
                List.of(falseLoanRule, trueLoanRule, trueLoanRule));

        assertEquals(expectedTotalLoans, eligibleLoans.size());
    }

    @Test
    public void assessEligibleLoansShouldReturnThreeLoansWhenCustomerEligibleForThreeLoans() {
        int expectedTotalLoans = 3;

        List<Loan> eligibleLoans = policy.assessEligibleLoans(
                customer,
                List.of(trueLoanRule, trueLoanRule, trueLoanRule));

        assertEquals(expectedTotalLoans, eligibleLoans.size());
    }

}
