package com.ramon.loans.core.specifications.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DisjunctionSpecificationTests {

    private static BaseSpecification<Object> falseSpec;
    private static BaseSpecification<Object> trueSpec;

    @BeforeAll
    public static void setUp() {
        falseSpec = (o) -> false;
        trueSpec = (o) -> true;
    }

    @Test
    public void disjunctionSpecificationShouldReturnTrueWhenCompositeTrueOrTrue() {
        Object candidate = new Object();
        var disjunction = new DisjunctionSpecification<>(trueSpec, trueSpec);

        Assertions.assertTrue(disjunction.isSatisfiedBy(candidate));
    }

    @Test
    public void disjunctionSpecificationShouldReturnTrueWhenCompositeTrueOrFalse() {
        Object candidate = new Object();
        var disjunction = new DisjunctionSpecification<>(trueSpec, falseSpec);

        Assertions.assertTrue(disjunction.isSatisfiedBy(candidate));
    }

    @Test
    public void disjunctionSpecificationShouldReturnTrueWhenCompositeFalseOrTrue() {
        Object candidate = new Object();
        var disjunction = new DisjunctionSpecification<>(falseSpec, trueSpec);

        Assertions.assertTrue(disjunction.isSatisfiedBy(candidate));
    }

    @Test
    public void disjunctionSpecificationShouldReturnFalseWhenCompositeFalseOrFalse() {
        Object candidate = new Object();
        var disjunction = new DisjunctionSpecification<>(falseSpec, falseSpec);

        Assertions.assertFalse(disjunction.isSatisfiedBy(candidate));
    }

}
