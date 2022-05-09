package dk.jonatanbuus.counterparty_fee_calculator.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

/**
 * Definition of a mapstruct instance for performing the following mappings for the calculation of a counterparty fee:
 * 
 * @see <a href="https://mapstruct.org/">Mapstruct</a>
 */
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CounterpartyFeeMapper {

}