package com.ramon.loans.core.specifications.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NegationSpecificationTests {
    
    @Test
    public void negationSpecificationShouldReturnTrueWhenFalse() {
        Object candidate = new Object();
        var negation = new NegationSpecification<>((o) -> false);

        Assertions.assertTrue(negation.isSatisfiedBy(candidate));
    }

    @Test
    public void negationSpecificationShouldReturnFalseWhenTrue() {
        Object candidate = new Object();
        var negation = new NegationSpecification<>((o) -> true);

        Assertions.assertFalse(negation.isSatisfiedBy(candidate));
    }

}
