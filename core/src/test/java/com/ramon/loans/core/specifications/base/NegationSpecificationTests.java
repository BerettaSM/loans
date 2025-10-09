package com.ramon.loans.core.specifications.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NegationSpecificationTests {

    private static BaseSpecification<Object> falseSpec;
    private static BaseSpecification<Object> trueSpec;

    @BeforeAll
    public static void setUp() {
        falseSpec = (o) -> false;
        trueSpec = (o) -> true;
    }

    @Test
    public void negationSpecificationShouldReturnTrueWhenFalse() {
        Object candidate = new Object();
        var negation = new NegationSpecification<>(falseSpec);

        Assertions.assertTrue(negation.isSatisfiedBy(candidate));
    }

    @Test
    public void negationSpecificationShouldReturnFalseWhenTrue() {
        Object candidate = new Object();
        var negation = new NegationSpecification<>(trueSpec);

        Assertions.assertFalse(negation.isSatisfiedBy(candidate));
    }

}
