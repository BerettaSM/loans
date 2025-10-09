package com.ramon.loans.core.specifications.base;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NegationSpecification<T> implements BaseSpecification<T> {

    private final BaseSpecification<T> spec;

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return !spec.isSatisfiedBy(candidate);
    }
    
}
