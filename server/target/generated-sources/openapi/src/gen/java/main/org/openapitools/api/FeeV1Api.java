/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.CounterpartyFee;
import org.openapitools.model.StatusMessage;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-09T12:24:31.479218+02:00[Europe/Paris]")
@Validated
@Api(value = "FeeV1", description = "the FeeV1 API")
public interface FeeV1Api {

    /**
     * GET /v1/{counterparty_id}/calculate-counterparty-fee : Calculates the counterparty fee for the specified counterparty
     * Calculates the counterparty fee for the specified counterparty, please note that: * The calculation for the counterparty fee may vary depending on the specified counterparty 
     *
     * @param counterpartyId The unique id of the counterparty for whom the fee should be calculated (required)
     * @return The details for the calculated counterparty fee (status code 200)
     *         or Bad request - The counterparty id is missing from the path (status code 400)
     *         or Forbidden - The caller has successfully authenticated, but is not authorized to calculate the counterparty fee for the specified counterparty (status code 403)
     *         or Not found - The specified counterparty could not be found (status code 404)
     *         or Internal server error - Calculation of the counterparty fee failed (status code 500)
     */
    @ApiOperation(value = "Calculates the counterparty fee for the specified counterparty", nickname = "calculateCounterpartyFee", notes = "Calculates the counterparty fee for the specified counterparty, please note that: * The calculation for the counterparty fee may vary depending on the specified counterparty ", response = CounterpartyFee.class, authorizations = {
        
        @Authorization(value = "myAuth")
         }, tags={ "fee_v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The details for the calculated counterparty fee", response = CounterpartyFee.class),
        @ApiResponse(code = 400, message = "Bad request - The counterparty id is missing from the path"),
        @ApiResponse(code = 403, message = "Forbidden - The caller has successfully authenticated, but is not authorized to calculate the counterparty fee for the specified counterparty", response = StatusMessage.class),
        @ApiResponse(code = 404, message = "Not found - The specified counterparty could not be found", response = StatusMessage.class),
        @ApiResponse(code = 500, message = "Internal server error - Calculation of the counterparty fee failed", response = StatusMessage.class) })
    @GetMapping(
        value = "/v1/{counterparty_id}/calculate-counterparty-fee",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<CounterpartyFee>> calculateCounterpartyFee(@Min(10000)@ApiParam(value = "The unique id of the counterparty for whom the fee should be calculated",required=true) @PathVariable("counterparty_id") Integer counterpartyId, @ApiIgnore final ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"fee\" : { \"value\" : 1000 } }";
                result = ApiUtil.getExampleResponse(exchange, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

}
