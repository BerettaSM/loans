package com.ramon.loans.application.ruleconfig;

import java.util.List;

import com.ramon.loans.core.domain.enums.State;
import com.ramon.loans.core.domain.models.Loan;
import com.ramon.loans.core.domain.rule.LoanRule;
import static com.ramon.loans.core.domain.rule.specifications.AgeSpec.youngerThan;
import static com.ramon.loans.core.domain.rule.specifications.IncomeSpec.incomeBetween;
import static com.ramon.loans.core.domain.rule.specifications.IncomeSpec.incomeLowerThanOrEqual;
import static com.ramon.loans.core.domain.rule.specifications.LocationSpec.locatedAt;

public class GuaranteedLoanRule extends LoanRule {
    
    public GuaranteedLoanRule() {
        super(
            new Loan(Loan.Type.GUARANTEED, 3),
            List.of(
                incomeLowerThanOrEqual(3000.0),
                incomeBetween(3000.0, 5000.0)
                    .and(youngerThan(30)).and(locatedAt(State.SP))));
    }

}
