package com.ramon.loans.core.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Loan {
    
    @NonNull
    @EqualsAndHashCode.Include
    private final Type type;
    
    @NonNull
    private final Integer interestRate;

    public enum Type {
        PERSONAL,
        CONSIGNMENT,
        GUARANTEED
    }

}
