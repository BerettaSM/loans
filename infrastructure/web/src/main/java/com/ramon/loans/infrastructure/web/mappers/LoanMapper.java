package com.ramon.loans.infrastructure.web.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ramon.loans.application.models.LoanAssessmentResponseModel;
import com.ramon.loans.application.models.LoanResponseModel;
import com.ramon.loans.infrastructure.web.dto.LoanAssessmentDTO;
import com.ramon.loans.infrastructure.web.dto.LoanDTO;

@Component
public class LoanMapper {

    public LoanAssessmentDTO toLoanAssessmentDTO(LoanAssessmentResponseModel loanAssessmentResponseModel) {
        LoanAssessmentDTO loanAssessmentDTO = new LoanAssessmentDTO();
        loanAssessmentDTO.setCustomer(loanAssessmentResponseModel.getCustomer());
        List<LoanDTO> loanDTOs = loanAssessmentResponseModel
                .getLoans()
                .stream()
                .map(this::toLoanDto)
                .toList();
        loanAssessmentDTO.setLoans(loanDTOs);
        return loanAssessmentDTO;
    }

    public LoanDTO toLoanDto(LoanResponseModel loanResponseModel) {
        LoanDTO loanDTO = new LoanDTO();
        loanDTO.setType(loanResponseModel.getType());
        loanDTO.setInterestRate(loanResponseModel.getInterestRate());
        return loanDTO;
    }

}
