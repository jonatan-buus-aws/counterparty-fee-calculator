package dk.jonatanbuus.counterparty_fee_calculator.controller;

import org.openapitools.api.FeeV1Api;
import org.openapitools.model.CounterpartyFee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import dk.jonatanbuus.counterparty_fee_calculator.exception.CounterpartyNotFoundException;
import dk.jonatanbuus.counterparty_fee_calculator.exception.InvalidCounterpartyIdException;
import dk.jonatanbuus.counterparty_fee_calculator.mapper.CounterpartyFeeMapper;
import dk.jonatanbuus.counterparty_fee_calculator.service.CounterpartyFeeCalculationService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * REST Controller for handling requests related to the counterparty fee calculation.
 * 
 */
@RequiredArgsConstructor
@RestController
@Api(value = "CounterpartyFeeController", description = "REST Controller for handling requests related to the counterparty fee calculation")
public class CounterpartyFeeController extends AbstractController implements FeeV1Api {
    /**
     * Spring Data Service for handling the calculation of the counterparty fee
     */
    private final CounterpartyFeeCalculationService service;
    /**
     * The mapstruct instance for performing the counterparty fee mappings
     */
    private final CounterpartyFeeMapper mapper;
    @Override
    public Mono<ResponseEntity<CounterpartyFee>> calculateCounterpartyFee(Integer counterpartyId,
            ServerWebExchange exchange) {
        
        if (counterpartyId < 1000) {
            return Mono.error(new InvalidCounterpartyIdException(counterpartyId) );
        }
        else if (counterpartyId > 10000) {
            return Mono.error(new CounterpartyNotFoundException(counterpartyId) );
        }
        else {
            return this.service.calculateCounterpartyFee(counterpartyId)
                .flatMap(fee -> Mono.just(ResponseEntity.ok(fee) ) );
        }
    }
}