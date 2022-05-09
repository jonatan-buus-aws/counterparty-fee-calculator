package dk.jonatanbuus.counterparty_fee_calculator.service;

import org.openapitools.model.Amount;
import org.openapitools.model.CURRENCY;
import org.openapitools.model.CounterpartyFee;
import org.springframework.stereotype.Service;

import dk.jonatanbuus.counterparty_fee_calculator.mapper.CounterpartyFeeMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


/**
 * Service class for handling the calculation of the counterparty fee including:
 *  - Calculating the counterparty fee
 * 
 */
@Service
@RequiredArgsConstructor
public class CounterpartyFeeCalculationService {
    private final static int MIN_FEE = 50;
    private final static int MAX_FEE = 100;
    /**
     * The mapstruct instance for performing the counterparty fee mappings
     */
    private final CounterpartyFeeMapper mapper;

    public Mono<CounterpartyFee> calculateCounterpartyFee(Integer counterpartyId) {
        Amount fee = new Amount()
                        .currency(CURRENCY.DKK)
                        .value( (long) Math.floor(Math.random() * (MAX_FEE - MIN_FEE + 1) + MIN_FEE) );
        return Mono.just(new CounterpartyFee().fee(fee) );
    }
}