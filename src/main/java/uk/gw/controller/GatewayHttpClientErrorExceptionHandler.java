package uk.gw.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
@Order(1)
public class GatewayHttpClientErrorExceptionHandler {

  private final HttpHeaders httpHeaders;

  public GatewayHttpClientErrorExceptionHandler() {
    httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    log.info("HttpClientErrorExceptionHandler configured");
  }

  @ExceptionHandler(HttpClientErrorException.class)
  protected ResponseEntity<?> handleConflict(HttpClientErrorException httpClientErrorException, WebRequest request) {
    log.debug("handle HttpServerErrorException", httpClientErrorException);
    if (log.isDebugEnabled()) {
      log.debug("Raw error message from Microservice is {}", httpClientErrorException.getResponseBodyAsString());
    }
    ResponseEntity<?> responseEntity = ResponseEntity.status(httpClientErrorException.getStatusCode()).headers(httpHeaders).build();

    return responseEntity;
  }

}
