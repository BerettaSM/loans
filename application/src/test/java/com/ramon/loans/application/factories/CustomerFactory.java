package com.ramon.loans.application.factories;

import java.math.BigDecimal;

import com.ramon.loans.application.models.CustomerRequestModel;
import com.ramon.loans.core.domain.enums.State;

public class CustomerFactory {
    
    public static final CustomerRequestModel createCustomerRequestModel() {
        CustomerRequestModel customer = new CustomerRequestModel();
        customer.setName("John Doe");
        customer.setCpf("000.000.000-00");
        customer.setIncome(BigDecimal.ZERO);
        customer.setAge(42);
        customer.setLocation(State.AC.toString());
        return customer;
    }

}
