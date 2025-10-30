package com.ramon.loans.application.ports.in;

import com.ramon.loans.application.models.CustomerRequestModel;
import com.ramon.loans.application.models.LoanAssessmentResponseModel;
import com.ramon.loans.core.domain.usecases.UseCase;

public interface AssessLoansInputPort extends UseCase<CustomerRequestModel, LoanAssessmentResponseModel> {
}
