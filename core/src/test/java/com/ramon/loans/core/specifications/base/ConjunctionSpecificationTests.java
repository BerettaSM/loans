package com.ramon.loans.core.specifications.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConjunctionSpecificationTests {

    @Test
    public void conjunctionSpecificationShouldReturnTrueWhenCompositeTrueAndTrue() {
        Object candidate = new Object();
        var conjuction = new ConjunctionSpecification<>((o) -> true, (o) -> true);

        Assertions.assertTrue(conjuction.isSatisfiedBy(candidate));
    }

    @Test
    public void conjunctionSpecificationShouldReturnFalseWhenCompositeTrueAndFalse() {
        Object candidate = new Object();
        var conjuction = new ConjunctionSpecification<>((o) -> true, (o) -> false);

        Assertions.assertFalse(conjuction.isSatisfiedBy(candidate));
    }

    @Test
    public void conjunctionSpecificationShouldReturnFalseWhenCompositeFalseAndTrue() {
        Object candidate = new Object();
        var conjuction = new ConjunctionSpecification<>((o) -> false, (o) -> true);

        Assertions.assertFalse(conjuction.isSatisfiedBy(candidate));
    }

    @Test
    public void conjunctionSpecificationShouldReturnFalseWhenCompositeFalseAndFalse() {
        Object candidate = new Object();
        var conjuction = new ConjunctionSpecification<>((o) -> false, (o) -> false);

        Assertions.assertFalse(conjuction.isSatisfiedBy(candidate));
    }

}
