package com.ramon.loans.infrastructure.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.loans.application.models.CustomerRequestModel;
import com.ramon.loans.application.models.LoanAssessmentResponseModel;
import com.ramon.loans.application.ports.in.AssessLoansInputPort;
import com.ramon.loans.infrastructure.web.dto.CustomerDTO;
import com.ramon.loans.infrastructure.web.dto.LoanAssessmentDTO;
import com.ramon.loans.infrastructure.web.mappers.CustomerMapper;
import com.ramon.loans.infrastructure.web.mappers.LoanMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoanController {

    private final AssessLoansInputPort assessLoansInputPort;

    private final CustomerMapper customerMapper;
    private final LoanMapper loanMapper;

    @PostMapping("/customer-loans")
    public ResponseEntity<LoanAssessmentDTO> assessLoans(@RequestBody CustomerDTO dto) {
        CustomerRequestModel customer = customerMapper.toRequestModel(dto);
        LoanAssessmentResponseModel loanAssessment = assessLoansInputPort.execute(customer);
        return ResponseEntity.ok(loanMapper.toLoanAssessmentDTO(loanAssessment));
    }

}
