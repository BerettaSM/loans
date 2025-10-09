package com.ramon.loans.core.specifications.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DisjunctionSpecificationTests {

    @Test
    public void disjunctionSpecificationShouldReturnTrueWhenCompositeTrueOrTrue() {
        Object candidate = new Object();
        var disjunction = new DisjunctionSpecification<>((o) -> true, (o) -> true);

        Assertions.assertTrue(disjunction.isSatisfiedBy(candidate));
    }

    @Test
    public void disjunctionSpecificationShouldReturnTrueWhenCompositeTrueOrFalse() {
        Object candidate = new Object();
        var disjunction = new DisjunctionSpecification<>((o) -> true, (o) -> false);

        Assertions.assertTrue(disjunction.isSatisfiedBy(candidate));
    }

    @Test
    public void disjunctionSpecificationShouldReturnTrueWhenCompositeFalseOrTrue() {
        Object candidate = new Object();
        var disjunction = new DisjunctionSpecification<>((o) -> false, (o) -> true);

        Assertions.assertTrue(disjunction.isSatisfiedBy(candidate));
    }

    @Test
    public void disjunctionSpecificationShouldReturnFalseWhenCompositeFalseOrFalse() {
        Object candidate = new Object();
        var disjunction = new DisjunctionSpecification<>((o) -> false, (o) -> false);

        Assertions.assertFalse(disjunction.isSatisfiedBy(candidate));
    }

}
