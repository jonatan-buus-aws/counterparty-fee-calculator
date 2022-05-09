
package dk.jonatanbuus.counterparty_fee_calculator.controller;

import java.nio.charset.StandardCharsets;

import org.openapitools.api.DocumentationV1Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import dk.jonatanbuus.counterparty_fee_calculator.service.DocumentationService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * REST Controller for serving the OpenAPI schema
 * 
 */
@RequiredArgsConstructor
@RestController
@Api(value = "DocumentationController", description = "REST Controller for serving the OpenAPI schema")
public class DocumentationController extends AbstractController implements DocumentationV1Api {
    private final static MediaType TEXT_YAML = new MediaType("text", "yaml", StandardCharsets.UTF_8);

    /**
     * Spring Data Service for retrieving the OpenAPI schema
     */
    private final DocumentationService service;

    @Override
    public Mono<ResponseEntity<String>> getDocumentation(ServerWebExchange exchange) {
        
        return Mono.just(ResponseEntity.ok()
                            .header("content-type", TEXT_YAML.toString() )
                            .body(this.service.getDocumentation() ) );
    }
}