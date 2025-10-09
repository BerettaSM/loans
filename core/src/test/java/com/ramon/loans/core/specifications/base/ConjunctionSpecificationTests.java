package com.ramon.loans.core.specifications.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ConjunctionSpecificationTests {

    private static BaseSpecification<Object> falseSpec;
    private static BaseSpecification<Object> trueSpec;

    @BeforeAll
    public static void setUp() {
        falseSpec = (o) -> false;
        trueSpec = (o) -> true;
    }

    @Test
    public void conjunctionSpecificationShouldReturnTrueWhenCompositeTrueAndTrue() {
        Object candidate = new Object();
        var conjuction = new ConjunctionSpecification<>(trueSpec, trueSpec);

        Assertions.assertTrue(conjuction.isSatisfiedBy(candidate));
    }

    @Test
    public void conjunctionSpecificationShouldReturnFalseWhenCompositeTrueAndFalse() {
        Object candidate = new Object();
        var conjuction = new ConjunctionSpecification<>(trueSpec, falseSpec);

        Assertions.assertFalse(conjuction.isSatisfiedBy(candidate));
    }

    @Test
    public void conjunctionSpecificationShouldReturnFalseWhenCompositeFalseAndTrue() {
        Object candidate = new Object();
        var conjuction = new ConjunctionSpecification<>(falseSpec, trueSpec);

        Assertions.assertFalse(conjuction.isSatisfiedBy(candidate));
    }

    @Test
    public void conjunctionSpecificationShouldReturnFalseWhenCompositeFalseAndFalse() {
        Object candidate = new Object();
        var conjuction = new ConjunctionSpecification<>(falseSpec, falseSpec);

        Assertions.assertFalse(conjuction.isSatisfiedBy(candidate));
    }

}
