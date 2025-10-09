package com.ramon.loans.core.specifications.base;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DisjunctionSpecification<T> implements BaseSpecification<T> {

    private final BaseSpecification<T> leftSpec;
    private final BaseSpecification<T> rightSpec;

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return leftSpec.isSatisfiedBy(candidate) || rightSpec.isSatisfiedBy(candidate);
    }

}
