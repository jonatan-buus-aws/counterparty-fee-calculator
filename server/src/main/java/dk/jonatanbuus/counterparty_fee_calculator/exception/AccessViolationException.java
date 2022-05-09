package dk.jonatanbuus.counterparty_fee_calculator.exception;

import org.openapitools.model.STATUSCODE;
import org.springframework.http.HttpStatus;

/**
 * Represents the exceptional circumstance when the requestor does not have access to the specified entity
 */
public class AccessViolationException extends AbstractResponseStatusException {
    public AccessViolationException (STATUSCODE code, String message) {
        super(HttpStatus.FORBIDDEN, code, message);
    }
}
