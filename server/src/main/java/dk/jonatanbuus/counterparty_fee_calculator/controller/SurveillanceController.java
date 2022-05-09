package dk.jonatanbuus.counterparty_fee_calculator.controller;

import org.openapitools.api.SurveillanceV1Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * REST Controller for handling requests related to surveillance.
 * 
 */
@RequiredArgsConstructor
@RestController
@Api(value = "SurveillanceController", description = "REST Controller for handling requests related to surveillance")
public class SurveillanceController extends AbstractController implements SurveillanceV1Api {
    @Override
    public Mono<ResponseEntity<Void>> livenessProbe(ServerWebExchange exchange) {
        
        return Mono.just(ResponseEntity.ok(null) );
    }
    
}