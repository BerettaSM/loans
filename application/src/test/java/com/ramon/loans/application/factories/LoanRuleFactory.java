package com.ramon.loans.application.factories;

import com.ramon.loans.application.ruleconfig.GuaranteedLoanRule;
import com.ramon.loans.application.ruleconfig.PersonalLoanRule;

public class LoanRuleFactory {
    
    public static final PersonalLoanRule createPersonalLoanRule() {
        return new PersonalLoanRule();
    }

    public static final GuaranteedLoanRule createGuaranteedLoanRule() {
        return new GuaranteedLoanRule();
    }

}
