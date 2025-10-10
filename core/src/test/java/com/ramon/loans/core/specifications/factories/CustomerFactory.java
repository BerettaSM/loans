package com.ramon.loans.core.specifications.factories;

import java.math.BigDecimal;

import com.ramon.loans.core.entities.Customer;
import com.ramon.loans.core.enums.State;

public class CustomerFactory {

    public static final Customer withAge(Integer age) {
        Customer customer = createCustomer();
        customer.setAge(age);
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
