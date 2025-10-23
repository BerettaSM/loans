package com.ramon.loans.coretest.specifications;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ramon.loans.core.specifications.DisjunctionSpecification;
import com.ramon.loans.core.specifications.Specification;
import com.ramon.loans.coretest.factories.SpecFactory;

public class DisjunctionSpecificationTests {

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
    public void disjunctionSpecificationShouldReturnTrueWhenCompositeTrueOrTrue() {
        var disjunction = new DisjunctionSpecification<>(trueSpec, trueSpec);

        assertTrue(disjunction.isSatisfiedBy(candidate));
    }

    @Test
    public void disjunctionSpecificationShouldReturnTrueWhenCompositeTrueOrFalse() {
        var disjunction = new DisjunctionSpecification<>(trueSpec, falseSpec);

        assertTrue(disjunction.isSatisfiedBy(candidate));
    }

    @Test
    public void disjunctionSpecificationShouldReturnTrueWhenCompositeFalseOrTrue() {
        var disjunction = new DisjunctionSpecification<>(falseSpec, trueSpec);

        assertTrue(disjunction.isSatisfiedBy(candidate));
    }

    @Test
    public void disjunctionSpecificationShouldReturnFalseWhenCompositeFalseOrFalse() {
        var disjunction = new DisjunctionSpecification<>(falseSpec, falseSpec);

        assertFalse(disjunction.isSatisfiedBy(candidate));
    }

}
