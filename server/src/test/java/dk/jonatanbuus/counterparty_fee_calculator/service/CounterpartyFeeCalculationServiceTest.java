package dk.jonatanbuus.counterparty_fee_calculator.service;

import static dk.jonatanbuus.counterparty_fee_calculator.helper.CounterpartyFeeAssertHelper.assertEquals;

import org.junit.jupiter.api.Test;
import org.openapitools.model.CounterpartyFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dk.jonatanbuus.counterparty_fee_calculator.CounterpartyFeeMockValues;
import dk.jonatanbuus.counterparty_fee_calculator.mapper.CounterpartyFeeMapper;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class CounterpartyFeeCalculationServiceTest extends CounterpartyFeeMockValues {

    /**
     * Spring Data Service for handling the calculation of the counterparty fee
     */
    @Autowired
    private CounterpartyFeeCalculationService service;
    /**
     * The mapstruct instance for performing the counterparty fee mappings
     */
    @Autowired
    private CounterpartyFeeMapper mapper;

    /* ========== CALCULATE COUNTERPARTY FEE TESTS START ========== */
    /**
     * Performs a test for calculating the counterparty fee using the counterparty fee calculation service
     */
    @Test
    public void testCalculateCounterpartyFee() {
        // Given
        int counterpartyId = this.counterpartyId;
        CounterpartyFee expectedFee = this.expectedFee;
        expectedFee.getFee().value(-1L);

        // When
        final Mono<CounterpartyFee> result = this.service.calculateCounterpartyFee(counterpartyId);

        // Verify the results
        result.as(StepVerifier::create)
            .expectNextMatches(fee -> {
                assertEquals(expectedFee, fee);
                return true;
            })
            .verifyComplete();
    }

    /* ========== CALCULATE COUNTERPARTY TESTS END ========== */
}