package com.ramon.loans.core.specifications.base;

@FunctionalInterface
public interface BaseSpecification<T> {

    boolean isSatisfiedBy(T candidate);

    default BaseSpecification<T> and(BaseSpecification<T> other) {
        return new ConjunctionSpecification<>(this, other);
    }

}
