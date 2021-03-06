/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

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
@Api(value = "DocumentationV1", description = "the DocumentationV1 API")
public interface DocumentationV1Api {

    /**
     * GET /v1/api-docs : Retrieves the API specification for the counterparty fee calculator
     * Retrieves the API specification for the counterparty fee calculator
     *
     * @return The Open API specification for the counterparty fee calculator (status code 200)
     *         or Internal server error - Retrieval of the Open API specification failed (status code 500)
     */
    @ApiOperation(value = "Retrieves the API specification for the counterparty fee calculator", nickname = "getDocumentation", notes = "Retrieves the API specification for the counterparty fee calculator", response = String.class, authorizations = {
        
        @Authorization(value = "myAuth")
         }, tags={ "documentation_v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The Open API specification for the counterparty fee calculator", response = String.class),
        @ApiResponse(code = 500, message = "Internal server error - Retrieval of the Open API specification failed", response = StatusMessage.class) })
    @GetMapping(
        value = "/v1/api-docs",
        produces = { "text/plain", "application/json" }
    )
    default Mono<ResponseEntity<String>> getDocumentation(@ApiIgnore final ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(Mono.empty());

    }

}
