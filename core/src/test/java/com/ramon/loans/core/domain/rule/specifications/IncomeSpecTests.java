package com.ramon.loans.core.domain.rule.specifications;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.factories.CustomerFactory;

public class IncomeSpecTests {

    @Test
    public void incomeLowerThan5000ShouldReturnTrueWhenIncomeIs4999() {
        Customer candidate = CustomerFactory.withIncome(4999.0);

        boolean result = IncomeSpec.incomeLowerThan(5000.0).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void incomeLowerThan5000ShouldReturnFalseWhenIncomeIs5000() {
        Customer candidate = CustomerFactory.withIncome(5000.0);

        boolean result = IncomeSpec.incomeLowerThan(5000.0).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void incomeLowerThan5000ShouldReturnFalseWhenIncomeIs5001() {
        Customer candidate = CustomerFactory.withIncome(5001.0);

        boolean result = IncomeSpec.incomeLowerThan(5000.0).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void incomeLowerThanOrEqual5000ShouldReturnTrueWhenIncomeIs4999() {
        Customer candidate = CustomerFactory.withIncome(4999.0);

        boolean result = IncomeSpec.incomeLowerThanOrEqual(5000.0).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void incomeLowerThanOrEqual5000ShouldReturnTrueWhenIncomeIs5000() {
        Customer candidate = CustomerFactory.withIncome(5000.0);

        boolean result = IncomeSpec.incomeLowerThanOrEqual(5000.0).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void incomeLowerThanOrEqual5000ShouldReturnFalseWhenIncomeIs5001() {
        Customer candidate = CustomerFactory.withIncome(5001.0);

        boolean result = IncomeSpec.incomeLowerThanOrEqual(5000.0).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void incomeHigherThan5000ShouldReturnFalseWhenIncomeIs4999() {
        Customer candidate = CustomerFactory.withIncome(4999.0);

        boolean result = IncomeSpec.incomeHigherThan(5000.0).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void incomeHigherThan5000ShouldReturnFalseWhenIncomeIs5000() {
        Customer candidate = CustomerFactory.withIncome(5000.0);

        boolean result = IncomeSpec.incomeHigherThan(5000.0).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void incomeHigherThan5000ShouldReturnTrueWhenIncomeIs5001() {
        Customer candidate = CustomerFactory.withIncome(5001.0);

        boolean result = IncomeSpec.incomeHigherThan(5000.0).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void incomeHigherThanOrEqual5000ShouldReturnFalseWhenIncomeIs4999() {
        Customer candidate = CustomerFactory.withIncome(4999.0);

        boolean result = IncomeSpec.incomeHigherThanOrEqual(5000.0).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void incomeHigherThanOrEqual5000ShouldReturnTrueWhenIncomeIs5000() {
        Customer candidate = CustomerFactory.withIncome(5000.0);

        boolean result = IncomeSpec.incomeHigherThanOrEqual(5000.0).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void incomeHigherThanOrEqual5000ShouldReturnTrueWhenIncomeIs5001() {
        Customer candidate = CustomerFactory.withIncome(5001.0);

        boolean result = IncomeSpec.incomeHigherThanOrEqual(5000.0).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void incomeBetween4000And5000ShouldReturnTrueWhenIncomeIs4000() {
        Customer candidate = CustomerFactory.withIncome(4000.0);

        boolean result = IncomeSpec.incomeBetween(4000.0, 5000.0)
            .isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void incomeBetween4000And5000ShouldReturnTrueWhenIncomeIs4500() {
        Customer candidate = CustomerFactory.withIncome(4500.0);

        boolean result = IncomeSpec.incomeBetween(4000.0, 5000.0)
            .isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void incomeBetween4000And5000ShouldReturnTrueWhenIncomeIs5000() {
        Customer candidate = CustomerFactory.withIncome(5000.0);

        boolean result = IncomeSpec.incomeBetween(4000.0, 5000.0)
            .isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void incomeBetween4000And5000ShouldReturnFalseWhenIncomeIs3999() {
        Customer candidate = CustomerFactory.withIncome(3999.0);

        boolean result = IncomeSpec.incomeBetween(4000.0, 5000.0)
            .isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void incomeBetween4000And5000NegationShouldReturnTrueWhenIncomeIs3999() {
        Customer candidate = CustomerFactory.withIncome(3999.0);

        boolean result = IncomeSpec.incomeBetween(4000.0, 5000.0)
            .not().isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void incomeBetween4000And5000ShouldReturnFalseWhenIncomeIs5001() {
        Customer candidate = CustomerFactory.withIncome(5001.0);

        boolean result = IncomeSpec.incomeBetween(4000.0, 5000.0)
            .isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void incomeBetween4000And5000NegationShouldReturnTrueWhenIncomeIs5001() {
        Customer candidate = CustomerFactory.withIncome(5001.0);

        boolean result = IncomeSpec.incomeBetween(4000.0, 5000.0)
            .not().isSatisfiedBy(candidate);

        assertTrue(result);
    }

}
