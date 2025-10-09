package com.ramon.loans.core.specifications.base;

public class ConjunctionSpecification<T> implements BaseSpecification<T> {

    private final BaseSpecification<T> leftSpec;
    private final BaseSpecification<T> rightSpec;

    public <E extends BaseSpecification<T>> ConjunctionSpecification(E leftSpec, E rightSpec) {
        this.leftSpec = leftSpec;
        this.rightSpec = rightSpec;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return leftSpec.isSatisfiedBy(candidate) && rightSpec.isSatisfiedBy(candidate);
    }
    
}
