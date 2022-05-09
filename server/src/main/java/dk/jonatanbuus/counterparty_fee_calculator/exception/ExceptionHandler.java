package dk.jonatanbuus.counterparty_fee_calculator.exception;

import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.openapitools.model.STATUSCODE;
import org.openapitools.model.StatusMessage;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
@Slf4j
public class ExceptionHandler implements WebExceptionHandler {
  @Override
  public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
    ExceptionHandler.log.debug("handle({})", ex);
    
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    STATUSCODE code = null;
    if (ex instanceof AbstractResponseStatusException) {
        status = ( (AbstractResponseStatusException) ex).getStatus();
        code = ( (AbstractResponseStatusException) ex).getCode();
    }
    
    return this.respond(exchange.getResponse(), status, 
        new StatusMessage()
            .code(code)
            .message(String.format("%s: %s", status, ex.getMessage() ) ) );
  }
  private Mono<Void> respond(ServerHttpResponse response, HttpStatus status, StatusMessage message) {
    response.setStatusCode(status);
    return Mono.defer( () -> {
        String json = "";
        try {
          json = new ObjectMapper().writeValueAsString(message);
        }
        catch (JsonProcessingException e) {
          throw new RuntimeException(e);
        }
        DataBuffer buffer = response.bufferFactory().wrap(json.getBytes(StandardCharsets.UTF_8) );
        response.getHeaders().setContentLength(buffer.readableByteCount() );
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString() );
        return response.writeWith(Mono.just(buffer) );
      });
  }
}
