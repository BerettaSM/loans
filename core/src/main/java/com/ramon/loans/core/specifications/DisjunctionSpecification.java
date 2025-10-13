package com.ramon.loans.core.specifications;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DisjunctionSpecification<T> implements Specification<T> {

    private final Specification<T> leftSpec;
    private final Specification<T> rightSpec;

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return leftSpec.isSatisfiedBy(candidate) || rightSpec.isSatisfiedBy(candidate);
    }

}
