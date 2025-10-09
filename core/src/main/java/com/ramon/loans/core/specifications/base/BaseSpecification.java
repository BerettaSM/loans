package com.ramon.loans.core.specifications.base;

@FunctionalInterface
public interface BaseSpecification<T> {

    boolean isSatisfiedBy(T candidate);

}
