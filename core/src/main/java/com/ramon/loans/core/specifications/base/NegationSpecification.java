package com.ramon.loans.core.specifications.base;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NegationSpecification<T> implements Specification<T> {

    private final Specification<T> spec;

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return !spec.isSatisfiedBy(candidate);
    }

}
