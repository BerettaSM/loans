package com.ramon.loans.application.usecases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

import com.ramon.loans.application.factories.CustomerFactory;
import com.ramon.loans.application.factories.UseCaseFactory;
import com.ramon.loans.application.models.CustomerRequestModel;
import com.ramon.loans.core.domain.policies.LoanEligibilityPolicy;

public class AssessLoansUseCaseTests {
    
    @Mock
    private LoanEligibilityPolicy policy;

    private CustomerRequestModel customerRequestModel;

    private AssessLoansUseCase assessLoansUseCase;

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void cleanUp() throws Exception {
        closeable.close();
    }

    @BeforeEach
    public void initialization() {
        customerRequestModel = CustomerFactory.createCustomerRequestModel();

        assessLoansUseCase = UseCaseFactory.createAssessLoansUseCase(policy);
    }

    @Test
    public void executeShouldCallAssessEligibleLoansOnce() {
        assessLoansUseCase.execute(customerRequestModel);

        verify(policy, times(1)).assessEligibleLoans(any(), any());
    }

}
