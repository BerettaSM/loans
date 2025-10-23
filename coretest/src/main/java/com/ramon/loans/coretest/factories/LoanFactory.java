package com.ramon.loans.coretest.factories;

import java.util.List;

import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.domain.models.Loan;
import com.ramon.loans.core.domain.policies.LoanEligibilityPolicy;
import com.ramon.loans.core.domain.rule.LoanRule;
import com.ramon.loans.core.specifications.Specification;

public class LoanFactory {

    public static final LoanEligibilityPolicy createLoanEligibilityPolicy() {
        return new LoanEligibilityPolicy();
    }

    public static final LoanRule createTrueLoanRule() {
        Specification<Customer> trueSpec = SpecFactory.createTrueSpec();
        return createLoanRule(Loan.Type.PERSONAL, List.of(trueSpec));
    }

    public static final LoanRule createFalseLoanRule() {
        Specification<Customer> falseSpec = SpecFactory.createFalseSpec();
        return createLoanRule(Loan.Type.CONSIGNMENT, List.of(falseSpec));
    }

    public static final LoanRule createLoan(List<Specification<Customer>> specs) {
        return createLoanRule(Loan.Type.PERSONAL, specs);
    }

    public static final LoanRule createLoanRule(Loan.Type type, List<Specification<Customer>> specs) {
        Loan loan = createLoan(type, 0);
        return new LoanRule(loan, specs);
    }

    public static final Loan createLoan() {
        return createLoan(Loan.Type.PERSONAL, 0);
    }

    public static final Loan createLoan(Loan.Type type, Integer interestRate) {
        return new Loan(type, interestRate);
    }

}
