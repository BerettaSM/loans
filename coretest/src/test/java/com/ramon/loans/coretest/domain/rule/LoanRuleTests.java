package com.ramon.loans.coretest.domain.rule;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.domain.rule.LoanRule;
import com.ramon.loans.core.specifications.Specification;
import com.ramon.loans.coretest.factories.CustomerFactory;
import com.ramon.loans.coretest.factories.LoanFactory;

@SuppressWarnings("unchecked")
public class LoanRuleTests {

    private Customer customer;
    private Specification<Customer> trueSpec;
    private Specification<Customer> falseSpec;

    @BeforeEach
    public void setUp() {
        customer = CustomerFactory.createCustomer();

        trueSpec = mock(Specification.class);
        when(trueSpec.isSatisfiedBy(any(Customer.class))).thenReturn(true);

        falseSpec = mock(Specification.class);
        when(falseSpec.isSatisfiedBy(any(Customer.class))).thenReturn(false);
    }

    @Test
    public void isEligibleShouldReturnTrueWhenSingleSpecResultsInTrue() {
        LoanRule rule = LoanFactory.createLoan(List.of(trueSpec));

        assertTrue(rule.isEligible(customer));
    }

    @Test
    public void isEligibleShouldReturnFalseWhenSingleSpecResultsInFalse() {
        LoanRule rule = LoanFactory.createLoan(List.of(falseSpec));

        assertFalse(rule.isEligible(customer));
    }

    @Test
    public void isEligibleShouldReturnTrueWhenLastSpecResultsInTrue() {
        LoanRule rule = LoanFactory.createLoan(List.of(falseSpec, trueSpec));

        assertTrue(rule.isEligible(customer));
    }

    @Test
    public void isEligibleShouldReturnTrueWhenAnySpecResultsInTrue() {
        LoanRule rule = LoanFactory.createLoan(List.of(falseSpec, trueSpec, falseSpec));

        assertTrue(rule.isEligible(customer));
    }

    @Test
    public void isEligibleShouldReturnTrueWhenAllSpecsResultsInFalse() {
        LoanRule rule = LoanFactory.createLoan(List.of(falseSpec, falseSpec, falseSpec));

        assertFalse(rule.isEligible(customer));
    }

    @Test
    public void isEligibleShouldCallAllSpecsWhenGivenOneTrueSpec() {
        LoanRule rule = LoanFactory.createLoan(List.of(trueSpec));

        rule.isEligible(customer);

        verify(trueSpec, times(1)).isSatisfiedBy(customer);
    }

    @Test
    public void isEligibleShouldCallAllSpecsWhenGivenOneFalseSpecAndOneTrueSpec() {
        LoanRule rule = LoanFactory.createLoan(List.of(falseSpec, trueSpec));

        rule.isEligible(customer);

        verify(falseSpec, times(1)).isSatisfiedBy(customer);
        verify(trueSpec, times(1)).isSatisfiedBy(customer);
    }

    @Test
    public void isEligibleShouldCallAllSpecsWhenGivenMultipleFalseSpecs() {
        LoanRule rule = LoanFactory.createLoan(List.of(falseSpec, falseSpec, falseSpec));

        rule.isEligible(customer);

        verify(falseSpec, times(3)).isSatisfiedBy(customer);
    }

    @Test
    public void isEligibleShouldStopCallingAtFirstTrueSpec() {
        LoanRule rule = LoanFactory.createLoan(List.of(trueSpec, trueSpec, falseSpec));

        rule.isEligible(customer);

        verify(trueSpec, times(1)).isSatisfiedBy(customer);
        verify(falseSpec, times(0)).isSatisfiedBy(customer);
    }

}
