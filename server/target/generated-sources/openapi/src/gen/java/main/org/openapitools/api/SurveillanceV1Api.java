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
@Api(value = "SurveillanceV1", description = "the SurveillanceV1 API")
public interface SurveillanceV1Api {

    /**
     * GET /v1/liveness-probe : End-point for the liveness probe, which verifies that the system is running
     * End-point for the liveness probe, which verifies that the system is running 
     *
     * @return The details for the initialized payment (status code 200)
     *         or Internal server error (status code 500)
     *         or Temporarily unavailable (status code 503)
     */
    @ApiOperation(value = "End-point for the liveness probe, which verifies that the system is running", nickname = "livenessProbe", notes = "End-point for the liveness probe, which verifies that the system is running ", authorizations = {
        
        @Authorization(value = "myAuth")
         }, tags={ "surveillance_v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The details for the initialized payment"),
        @ApiResponse(code = 500, message = "Internal server error", response = StatusMessage.class),
        @ApiResponse(code = 503, message = "Temporarily unavailable", response = StatusMessage.class) })
    @GetMapping(
        value = "/v1/liveness-probe",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Void>> livenessProbe(@ApiIgnore final ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(Mono.empty());

    }

}
