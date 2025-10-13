package com.ramon.loans.core.specifications;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ConjunctionSpecificationTests {

    private static Specification<Object> falseSpec;
    private static Specification<Object> trueSpec;

    private static Object candidate;

    @BeforeAll
    public static void setUp() {
        falseSpec = (o) -> false;
        trueSpec = (o) -> true;

        candidate = new Object();
    }

    @Test
    public void conjunctionSpecificationShouldReturnTrueWhenCompositeTrueAndTrue() {
        var conjuction = new ConjunctionSpecification<>(trueSpec, trueSpec);

        assertTrue(conjuction.isSatisfiedBy(candidate));
    }

    @Test
    public void conjunctionSpecificationShouldReturnFalseWhenCompositeTrueAndFalse() {
        var conjuction = new ConjunctionSpecification<>(trueSpec, falseSpec);

        assertFalse(conjuction.isSatisfiedBy(candidate));
    }

    @Test
    public void conjunctionSpecificationShouldReturnFalseWhenCompositeFalseAndTrue() {
        var conjuction = new ConjunctionSpecification<>(falseSpec, trueSpec);

        assertFalse(conjuction.isSatisfiedBy(candidate));
    }

    @Test
    public void conjunctionSpecificationShouldReturnFalseWhenCompositeFalseAndFalse() {
        var conjuction = new ConjunctionSpecification<>(falseSpec, falseSpec);

        assertFalse(conjuction.isSatisfiedBy(candidate));
    }

}
