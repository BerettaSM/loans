package com.ramon.loans.application.mappers;

import com.ramon.loans.application.models.CustomerRequestModel;
import com.ramon.loans.core.domain.enums.State;
import com.ramon.loans.core.domain.models.Customer;

public class CustomerMapper {

    public Customer toDomain(CustomerRequestModel requestModel) {
        Customer customer = new Customer();
        customer.setName(requestModel.getName());
        customer.setCpf(requestModel.getCpf());
        customer.setAge(requestModel.getAge());
        customer.setIncome(requestModel.getIncome());
        customer.setLocation(State.valueOf(requestModel.getLocation()));
        return customer;
    }

}
