package com.ramon.loans.core.factories;

import com.ramon.loans.core.specifications.Specification;

public class SpecFactory {

    public static final <E> Specification<E> createTrueSpec() {
        return ignore -> true;
    }

    public static final <E> Specification<E> createFalseSpec() {
        return ignore -> false;
    }

}
