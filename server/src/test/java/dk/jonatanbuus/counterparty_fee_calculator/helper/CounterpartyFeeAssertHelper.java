package dk.jonatanbuus.counterparty_fee_calculator.helper;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.openapitools.model.Amount;
import org.openapitools.model.CounterpartyFee;

;

/**
 * Helper class containing assertion methods for verifying the calculation of the counterparty fee
 */
public class CounterpartyFeeAssertHelper extends BaseEntityAssertHelper {
    /**
     * <em>Assert</em> that {@code expected} counterparty fee and {@code actual} counterparty fee are equal.
     * 
     * @param expected  The expected counterparty fee
     * @param actual    The actual counterparty fee
     */
    public static void assertEquals(CounterpartyFee expected, CounterpartyFee actual) {
        assertEquals(expected.getFee(), actual.getFee() );
    }
    /**
     * <em>Assert</em> that the {@code expected} amount and {@code actual} amount are equal.
     * 
     * @param expected  The expected amount
     * @param actual    The actual amount
     */
    public static void assertEquals(Amount expected, Amount actual) {
        Assertions.assertEquals(expected.getCurrency(), actual.getCurrency() );
        if (expected.getValue() < 0L) {
            assertTrue(actual.getValue() > 0);
        }
        else {
            Assertions.assertEquals(expected.getValue(), actual.getValue() );           
        }
    }
}