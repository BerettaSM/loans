package com.ramon.loans.core.domain.rule.specifications;

import java.math.BigDecimal;

import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.specifications.Specification;

public final class IncomeSpec {

    public static final Specification<Customer> incomeLowerThan(Double income) {
        return customer -> customer.getIncome().compareTo(BigDecimal.valueOf(income)) < 0;
    }

    public static final Specification<Customer> incomeLowerThanOrEqual(Double income) {
        return customer -> customer.getIncome().compareTo(BigDecimal.valueOf(income)) <= 0;
    }

    public static final Specification<Customer> incomeHigherThan(Double income) {
        return customer -> customer.getIncome().compareTo(BigDecimal.valueOf(income)) > 0;
    }

    public static final Specification<Customer> incomeHigherThanOrEqual(Double income) {
        return customer -> customer.getIncome().compareTo(BigDecimal.valueOf(income)) >= 0;
    }

    public static final Specification<Customer> incomeBetween(
            Double lowerBoundIncome,
            Double upperBoundIncome) {
        return incomeHigherThanOrEqual(lowerBoundIncome).and(incomeLowerThanOrEqual(upperBoundIncome));
    }

}
