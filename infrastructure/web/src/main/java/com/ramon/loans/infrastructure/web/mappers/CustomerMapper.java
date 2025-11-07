package com.ramon.loans.infrastructure.web.mappers;

import org.springframework.stereotype.Component;

import com.ramon.loans.application.models.CustomerRequestModel;
import com.ramon.loans.core.domain.enums.State;
import com.ramon.loans.infrastructure.web.dto.CustomerDTO;

@Component
public class CustomerMapper {

    public CustomerRequestModel toRequestModel(CustomerDTO dto) {
        CustomerRequestModel customerRequestModel = new CustomerRequestModel();
        customerRequestModel.setName(dto.getName());
        customerRequestModel.setAge(dto.getAge());
        customerRequestModel.setLocation(State.valueOf(dto.getLocation()));
        customerRequestModel.setCpf(dto.getCpf());
        customerRequestModel.setIncome(dto.getIncome());
        return customerRequestModel;
    }

}
