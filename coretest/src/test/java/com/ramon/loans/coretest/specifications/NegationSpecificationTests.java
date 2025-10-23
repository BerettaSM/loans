package com.ramon.loans.coretest.specifications;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ramon.loans.core.specifications.NegationSpecification;
import com.ramon.loans.core.specifications.Specification;
import com.ramon.loans.coretest.factories.SpecFactory;

public class NegationSpecificationTests {

    private static Specification<Object> falseSpec;
    private static Specification<Object> trueSpec;

    private static Object candidate;

    @BeforeAll
    public static void setUp() {
        falseSpec = SpecFactory.createFalseSpec();
        trueSpec = SpecFactory.createTrueSpec();

        candidate = new Object();
    }

    @Test
    public void negationSpecificationShouldReturnTrueWhenFalse() {
        var negation = new NegationSpecification<>(falseSpec);

        assertTrue(negation.isSatisfiedBy(candidate));
    }

    @Test
    public void negationSpecificationShouldReturnFalseWhenTrue() {
        var negation = new NegationSpecification<>(trueSpec);

        assertFalse(negation.isSatisfiedBy(candidate));
    }

}
