package com.ramon.loans.application.ruleconfig;

import java.util.List;

import com.ramon.loans.core.domain.models.Loan;
import com.ramon.loans.core.domain.rule.LoanRule;
import static com.ramon.loans.core.domain.rule.specifications.IncomeSpec.incomeHigherThanOrEqual;

public class ConsignmentLoanRule extends LoanRule {

    public ConsignmentLoanRule() {
        super(
            new Loan(Loan.Type.CONSIGNMENT, 2),
            List.of(incomeHigherThanOrEqual(5000.0)));
    }
    
}
