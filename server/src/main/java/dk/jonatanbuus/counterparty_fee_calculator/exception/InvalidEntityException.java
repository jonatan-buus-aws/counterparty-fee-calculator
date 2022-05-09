package dk.jonatanbuus.counterparty_fee_calculator.exception;

import org.openapitools.model.STATUSCODE;
import org.springframework.http.HttpStatus;

/**
 * Represents the exceptional circumstance when an entity contains invalid data
 */
public class InvalidEntityException extends AbstractResponseStatusException {
    public InvalidEntityException (STATUSCODE code, String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, code, message);
    }
    public InvalidEntityException (STATUSCODE code, String message, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, code, message, cause);
    }
}
