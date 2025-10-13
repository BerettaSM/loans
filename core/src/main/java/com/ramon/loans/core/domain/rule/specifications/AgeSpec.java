package com.ramon.loans.core.domain.rule.specifications;

import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.specifications.Specification;

public final class AgeSpec {

    public static final Specification<Customer> youngerThan(Integer age) {
        return customer -> customer.getAge() < age;
    }

    public static final Specification<Customer> youngerThanOrAt(Integer age) {
        return customer -> customer.getAge() <= age;
    }

    public static final Specification<Customer> olderThan(Integer age) {
        return customer -> customer.getAge() > age;
    }

    public static final Specification<Customer> olderThanOrAt(Integer age) {
        return customer -> customer.getAge() >= age;
    }

    public static final Specification<Customer> ageBetween(
            Integer lowerBoundAge,
            Integer upperBoundAge) {
        return olderThanOrAt(lowerBoundAge).and(youngerThanOrAt(upperBoundAge));
    }

}
