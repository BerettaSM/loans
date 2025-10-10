package com.ramon.loans.core.specifications.customer;

import com.ramon.loans.core.entities.Customer;
import com.ramon.loans.core.specifications.base.Specification;

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

    public static final Specification<Customer> between(
            Integer lowerBoundAge,
            Integer upperBoundAge) {
        return olderThanOrAt(lowerBoundAge).and(youngerThanOrAt(upperBoundAge));
    }

}
