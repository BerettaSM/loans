package com.ramon.loans.core.domain.rule;

import java.util.List;

import com.ramon.loans.core.domain.models.Customer;
import com.ramon.loans.core.domain.models.Loan;
import com.ramon.loans.core.specifications.Specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LoanRule {
    
    @NonNull
    @EqualsAndHashCode.Include
    private final Loan loan;

    @NonNull
    private final List<Specification<Customer>> specs;
    
    public boolean isEligible(Customer customer) {
        return specs.stream()
            .anyMatch(spec -> spec.isSatisfiedBy(customer));
    }

}
