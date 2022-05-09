package dk.jonatanbuus.counterparty_fee_calculator.controller;


import static dk.jonatanbuus.counterparty_fee_calculator.helper.BaseEntityAssertHelper.assertEquals;
import static dk.jonatanbuus.counterparty_fee_calculator.helper.CounterpartyFeeAssertHelper.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.openapitools.model.CounterpartyFee;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;

import dk.jonatanbuus.counterparty_fee_calculator.CounterpartyFeeMockValues;
import dk.jonatanbuus.counterparty_fee_calculator.exception.CounterpartyNotFoundException;
import dk.jonatanbuus.counterparty_fee_calculator.exception.InvalidCounterpartyIdException;
import dk.jonatanbuus.counterparty_fee_calculator.mapper.CounterpartyFeeMapper;
import dk.jonatanbuus.counterparty_fee_calculator.service.CounterpartyFeeCalculationService;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class CounterpartyFeeControllerTest extends CounterpartyFeeMockValues {
    /**
     * API controller for handling the counterparty fee calculation
     */
    @InjectMocks
    private CounterpartyFeeController controller;
    /**
     * Spring Data Service for handling the calculation of the counterparty fee
     */
    @Mock
    private CounterpartyFeeCalculationService service;
    /**
     * The mapstruct instance for performing the counterparty fee mappings
     */
    @Spy
    private CounterpartyFeeMapper mapper = Mappers.getMapper(CounterpartyFeeMapper.class);
    /**
     * The path for invoking the "Calculate Counterparty Fee" API.
     */
    private final static String CALCULATE_COUNTERPARTY_FEE_PATH = "/v1/%s/calculate-counterparty-fee";


    /* ========== CALCULATE COUNTERPARTY FEE TESTS START ========== */
    /**
     * Performs a test for calculating the counterparty fee through the API controller
     */
    @Test
    public void testCalculateCounterpartyFee() {
        // Given
        int counterpartyId = this.counterpartyId;
        ServerWebExchange exchange = this.createExchange(HttpMethod.GET, String.format(CounterpartyFeeControllerTest.CALCULATE_COUNTERPARTY_FEE_PATH, counterpartyId) );

        when(this.service.calculateCounterpartyFee(counterpartyId) )
            .thenReturn(Mono.just(this.expectedFee) );

        // When
        final Mono<ResponseEntity<CounterpartyFee>> result = this.controller.calculateCounterpartyFee(counterpartyId, exchange);

        // Verify the results
        result.as(StepVerifier::create)
            .expectNextMatches(response -> {
                CounterpartyFee actualFee = response.getBody();
                
                Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Invalid HTTP status code returned");
                
                assertEquals(this.expectedFee, actualFee);
                return true;
            }) 
            .verifyComplete();
    }

    /**
     * Performs a test for attempting to calculate the counterparty fee for an invalid counterparty through the API controller
     */
    @Test
    public void testInvalidCounterPartyId() {
        // Given
        int counterpartyId = this.counterpartyId - 1000;
        InvalidCounterpartyIdException expected = new InvalidCounterpartyIdException(counterpartyId);
        ServerWebExchange exchange = this.createExchange(HttpMethod.GET, String.format(CounterpartyFeeControllerTest.CALCULATE_COUNTERPARTY_FEE_PATH, counterpartyId) );

        when(this.service.calculateCounterpartyFee(counterpartyId) )
            .thenReturn(Mono.error(expected) );

        // When
        final Mono<ResponseEntity<CounterpartyFee>> result = this.controller.calculateCounterpartyFee(counterpartyId, exchange);

        // Verify the results
        result.as(StepVerifier::create)
            .expectErrorMatches(throwable -> {
                assertTrue(throwable instanceof InvalidCounterpartyIdException);
                assertEquals(expected, (InvalidCounterpartyIdException) throwable);
                return true;
            })
            .verify();
    }
    /**
     * Performs a test for attempting to calculate the counterparty fee for an unknown counterparty through the API controller
     */
    @Test
    public void testUnknownCounterparty() {
        // Given
        int counterpartyId = this.counterpartyId + 10000;
        CounterpartyNotFoundException expected = new CounterpartyNotFoundException(counterpartyId);
        ServerWebExchange exchange = this.createExchange(HttpMethod.GET, String.format(CounterpartyFeeControllerTest.CALCULATE_COUNTERPARTY_FEE_PATH, counterpartyId) );

        when(this.service.calculateCounterpartyFee(counterpartyId) )
            .thenReturn(Mono.error(expected) );

        // When
        final Mono<ResponseEntity<CounterpartyFee>> result = this.controller.calculateCounterpartyFee(counterpartyId, exchange);

        // Verify the results
        result.as(StepVerifier::create)
            .expectErrorMatches(throwable -> {
                assertTrue(throwable instanceof CounterpartyNotFoundException);
                assertEquals(expected, (CounterpartyNotFoundException) throwable);
                return true;
            })
            .verify();
    }
    /* ========== CALCULATE COUNTERPARTY FEE TESTS END ========== */
}