package dk.jonatanbuus.counterparty_fee_calculator.exception;

import org.openapitools.model.STATUSCODE;

/**
 * Represents the exceptional circumstance when the counterparty is invalid
 */
public class InvalidCounterpartyIdException extends InvalidEntityException {
    private InvalidCounterpartyIdException (String message) {
        super(STATUSCODE.INVALID_COUNTERPARTY_ID, message);
    }
    public InvalidCounterpartyIdException (int counterpartyId) {
        this(String.format("Counterparty: %s is invalid", counterpartyId) );
    }
}