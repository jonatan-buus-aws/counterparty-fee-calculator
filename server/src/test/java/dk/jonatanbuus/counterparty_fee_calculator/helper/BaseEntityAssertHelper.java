package dk.jonatanbuus.counterparty_fee_calculator.helper;

import org.junit.jupiter.api.Assertions;

import dk.jonatanbuus.counterparty_fee_calculator.exception.AbstractResponseStatusException;

/**
 * Helper class containing assertion methods for verifying a base entity
 */
public class BaseEntityAssertHelper {
    /**
     * <em>Assert</em> that {@code expected} exception and {@code actual} exception are equal.
     * 
     * @param expected  The expected exception
     * @param actual    The actual exception
     */
    public static void assertEquals(AbstractResponseStatusException expected, AbstractResponseStatusException actual) {
        Assertions.assertEquals(expected.getStatus(), actual.getStatus() );
        Assertions.assertEquals(expected.getCode(), actual.getCode() );
        Assertions.assertEquals(expected.getMessage(), actual.getMessage() );
    }
}