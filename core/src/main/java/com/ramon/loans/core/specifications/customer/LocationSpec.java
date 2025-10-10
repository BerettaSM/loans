package com.ramon.loans.core.specifications.customer;

import java.util.Arrays;

import com.ramon.loans.core.enums.State;
import com.ramon.loans.core.models.Customer;
import com.ramon.loans.core.specifications.base.Specification;

public final class LocationSpec {
    
    public static final Specification<Customer> locatedAt(State... locations) {
        return customer -> Arrays.stream(locations)
            .anyMatch(loc -> loc.equals(customer.getLocation()));
    }

}
