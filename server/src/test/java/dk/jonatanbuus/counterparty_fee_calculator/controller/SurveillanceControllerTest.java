package dk.jonatanbuus.counterparty_fee_calculator.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;

import dk.jonatanbuus.counterparty_fee_calculator.BaseTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class SurveillanceControllerTest extends BaseTest {
    /**
     * API controller for handling the surveillance probes
     */
    @InjectMocks
    private SurveillanceController controller;
    /**
     * The path for invoking the "Liveness Probe"" API.
     */
    private final static String LIVENESS_PROBE_PATH = "/v1/liveness-probe";


    /* ========== SURVEILLANCE TESTS START ========== */
    /**
     * Performs a test for accessing the liveness probe the API controller
     */
    @Test
    public void testLivenessProbe() {
        // Given
        ServerWebExchange exchange = this.createExchange(HttpMethod.GET, SurveillanceControllerTest.LIVENESS_PROBE_PATH);

        // When
        final Mono<ResponseEntity<Void>> result = this.controller.livenessProbe(exchange);

        // Verify the results
        result.as(StepVerifier::create)
            .expectNextMatches(response -> {                
                Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Invalid HTTP status code returned");
                return true;
            }) 
            .verifyComplete();
    }
    /* ========== SURVEILLANCE TESTS END ========== */
}