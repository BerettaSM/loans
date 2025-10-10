package com.ramon.loans.core.specifications.customer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.ramon.loans.core.enums.State;
import com.ramon.loans.core.models.Customer;
import com.ramon.loans.core.specifications.factories.CustomerFactory;

public class LocationSpecTests {
    
    @Test
    public void locatedAtSPShouldReturnTrueWhenCustomerLocatedAtSP() {
        Customer candidate = CustomerFactory.withLocation(State.SP);

        boolean result = LocationSpec.locatedAt(State.SP).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void locatedAtSPShouldReturnFalseWhenCustomerNotLocatedAtSP() {
        Customer candidate = CustomerFactory.withLocation(State.AC);

        boolean result = LocationSpec.locatedAt(State.SP).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void locatedAtSPOrRJShouldReturnTrueWhenCustomerLocatedAtSP() {
        Customer candidate = CustomerFactory.withLocation(State.SP);

        boolean result = LocationSpec.locatedAt(State.SP, State.RJ).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void locatedAtSPOrRJNegationShouldReturnFalseWhenCustomerLocatedAtSP() {
        Customer candidate = CustomerFactory.withLocation(State.SP);

        boolean result = LocationSpec.locatedAt(State.SP, State.RJ).not().isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void locatedAtSPOrRJShouldReturnTrueWhenCustomerLocatedAtRJ() {
        Customer candidate = CustomerFactory.withLocation(State.RJ);

        boolean result = LocationSpec.locatedAt(State.SP, State.RJ).isSatisfiedBy(candidate);

        assertTrue(result);
    }

    @Test
    public void locatedAtSPOrRJNegationShouldReturnFalseWhenCustomerLocatedAtRJ() {
        Customer candidate = CustomerFactory.withLocation(State.RJ);

        boolean result = LocationSpec.locatedAt(State.SP, State.RJ).not().isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void locatedAtSPOrRJShouldReturnFalseWhenCustomerNotLocatedAtSPOrRJ() {
        Customer candidate = CustomerFactory.withLocation(State.AL);

        boolean result = LocationSpec.locatedAt(State.SP, State.RJ).isSatisfiedBy(candidate);

        assertFalse(result);
    }

    @Test
    public void locatedAtSPOrRJNegationShouldReturnTrueWhenCustomerNotLocatedAtSPOrRJ() {
        Customer candidate = CustomerFactory.withLocation(State.AL);

        boolean result = LocationSpec.locatedAt(State.SP, State.RJ).not().isSatisfiedBy(candidate);

        assertTrue(result);
    }

}
