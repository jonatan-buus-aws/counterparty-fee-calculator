package dk.jonatanbuus.counterparty_fee_calculator.exception;

import org.openapitools.model.STATUSCODE;
import org.springframework.http.HttpStatus;

/**
 * Represents the exceptional circumstance when an entity could no be found
 */
public class EntityNotFoundException extends AbstractResponseStatusException {
    public EntityNotFoundException (STATUSCODE code, String message) {
        super(HttpStatus.NOT_FOUND, code, message);
    }
}
