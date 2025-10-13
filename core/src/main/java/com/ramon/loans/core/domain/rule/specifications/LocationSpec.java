package com.ramon.loans.core.domain.rule.specifications;

import java.util.Arrays;

import com.ramon.loans.core.domain.enums.State;
import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.specifications.Specification;

public final class LocationSpec {
    
    public static final Specification<Customer> locatedAt(State... locations) {
        return customer -> Arrays.stream(locations)
            .anyMatch(loc -> loc.equals(customer.getLocation()));
    }

}
