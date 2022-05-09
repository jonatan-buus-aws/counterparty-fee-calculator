package dk.jonatanbuus.counterparty_fee_calculator.exception;

import org.openapitools.model.STATUSCODE;

/**
 * Represents the exceptional circumstance when the counterparty could not be found
 */
public class CounterpartyNotFoundException extends EntityNotFoundException {
    private CounterpartyNotFoundException (String message) {
        super(STATUSCODE.COUNTERPARTY_NOT_FOUND, message);
    }
    public CounterpartyNotFoundException (int counterpartyId) {
        this(String.format("Counterparty: %s not found", counterpartyId) );
    }
}