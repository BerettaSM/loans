package com.ramon.loans.core.domain.rule.specifications;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.factories.CustomerFactory;

public class AgeSpecTests {

    @Test
    public void youngerThan30ShouldReturnTrueWhenCustomerIs29YearsOld() {
        Customer candidate = CustomerFactory.withAge(29);

        boolean result = AgeSpec.youngerThan(30).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void youngerThan30ShouldReturnFalseWhenCustomerIs30YearsOld() {
        Customer candidate = CustomerFactory.withAge(30);

        boolean result = AgeSpec.youngerThan(30).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void youngerThan30ShouldReturnFalseWhenCustomerIs31YearsOld() {
        Customer candidate = CustomerFactory.withAge(31);

        boolean result = AgeSpec.youngerThan(30).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void youngerThanOrAt30ShouldReturnTrueWhenCustomerIs29YearsOld() {
        Customer candidate = CustomerFactory.withAge(29);

        boolean result = AgeSpec.youngerThanOrAt(30).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void youngerThanOrAt30ShouldReturnTrueWhenCustomerIs30YearsOld() {
        Customer candidate = CustomerFactory.withAge(30);

        boolean result = AgeSpec.youngerThanOrAt(30).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void youngerThanOrAt30ShouldReturnFalseWhenCustomerIs31YearsOld() {
        Customer candidate = CustomerFactory.withAge(31);

        boolean result = AgeSpec.youngerThanOrAt(30).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void olderThan30ShouldReturnFalseWhenCustomerIs29YearsOld() {
        Customer candidate = CustomerFactory.withAge(29);

        boolean result = AgeSpec.olderThan(30).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void olderThan30ShouldReturnFalseWhenCustomerIs30YearsOld() {
        Customer candidate = CustomerFactory.withAge(30);

        boolean result = AgeSpec.olderThan(30).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void olderThan30ShouldReturnTrueWhenCustomerIs31YearsOld() {
        Customer candidate = CustomerFactory.withAge(31);

        boolean result = AgeSpec.olderThan(30).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void olderThanOrAt30ShouldReturnFalseWhenCustomerIs29YearsOld() {
        Customer candidate = CustomerFactory.withAge(29);

        boolean result = AgeSpec.olderThanOrAt(30).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void olderThanOrAt30ShouldReturnTrueWhenCustomerIs30YearsOld() {
        Customer candidate = CustomerFactory.withAge(30);

        boolean result = AgeSpec.olderThanOrAt(30).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void olderThanOrAt30ShouldReturnTrueWhenCustomerIs31YearsOld() {
        Customer candidate = CustomerFactory.withAge(31);

        boolean result = AgeSpec.olderThanOrAt(30).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void between30And40ShouldReturnTrueWhenCustomerIs30YearsOld() {
        Customer candidate = CustomerFactory.withAge(30);

        boolean result = AgeSpec.ageBetween(30, 40).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void between30And40ShouldReturnTrueWhenCustomerIs35YearsOld() {
        Customer candidate = CustomerFactory.withAge(35);

        boolean result = AgeSpec.ageBetween(30, 40).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void between30And40ShouldReturnTrueWhenCustomerIs40YearsOld() {
        Customer candidate = CustomerFactory.withAge(35);

        boolean result = AgeSpec.ageBetween(30, 40).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void between30And40ShouldReturnFalseWhenCustomerIs29YearsOld() {
        Customer candidate = CustomerFactory.withAge(29);

        boolean result = AgeSpec.ageBetween(30, 40).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void between30And40NegationShouldReturnTrueWhenCustomerIs29YearsOld() {
        Customer candidate = CustomerFactory.withAge(29);

        boolean result = AgeSpec.ageBetween(30, 40).not().isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void between30And40ShouldReturnFalseWhenCustomerIs41YearsOld() {
        Customer candidate = CustomerFactory.withAge(41);

        boolean result = AgeSpec.ageBetween(30, 40).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void between30And40NegationShouldReturnTrueWhenCustomerIs41YearsOld() {
        Customer candidate = CustomerFactory.withAge(41);

        boolean result = AgeSpec.ageBetween(30, 40).not().isSatisfiedBy(candidate);

        assertTrue(result);
    }

}
