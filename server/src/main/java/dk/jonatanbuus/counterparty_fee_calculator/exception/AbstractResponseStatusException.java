package dk.jonatanbuus.counterparty_fee_calculator.exception;
import org.openapitools.model.STATUSCODE;
import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * Represents an abstract exception while sending an HTTP Response.
 * Any exceptions of this type will return a standard status message with the following properties:
 *  - code
 *  - message
 */
@Getter
public abstract class AbstractResponseStatusException extends RuntimeException {
    /**
     * The HTTP Status that will be returned
     */
    private HttpStatus status;
    /**
     * The status code that will be returned
     */
    private STATUSCODE code;
    /**
     * Constructs a new status message
     * 
     * @param status    The HTTP Status that should be returned
     * @param code      The status code that should be returned
     * @param message   The status message that should be returned
     */
    public AbstractResponseStatusException (HttpStatus status, STATUSCODE code, String message) {
        this(status, code, message, null);
    }
    /**
     * Constructs a new status message
     * 
     * @param status    The HTTP Status that should be returned
     * @param code      The status code that should be returned
     * @param message   The status message that should be returned
     * @param cause     The cause (which is saved for later retrieval by the
     *                  {@link #getCause()} method). (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public AbstractResponseStatusException (HttpStatus status, STATUSCODE code, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.code = code;
    }
}
