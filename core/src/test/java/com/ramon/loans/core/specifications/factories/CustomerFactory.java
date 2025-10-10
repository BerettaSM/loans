package com.ramon.loans.core.specifications.factories;

import java.math.BigDecimal;

import com.ramon.loans.core.enums.State;
import com.ramon.loans.core.models.Customer;

public class CustomerFactory {

    public static final Customer withAge(Integer age) {
        Customer customer = createCustomer();
        customer.setAge(age);
        return customer;
    }

    public static final Customer withIncome(Double income) {
        Customer customer = createCustomer();
        customer.setIncome(BigDecimal.valueOf(income));
        return customer;
    }

    public static final Customer withLocation(State location) {
        Customer customer = createCustomer();
        customer.setLocation(location);
        return customer;
    }

    public static Customer createCustomer() {
        return new Customer(
            "John Doe", 
            "000.000.000-00", 
            50, 
            new BigDecimal("500.00"), 
            State.AC);
    }

}
