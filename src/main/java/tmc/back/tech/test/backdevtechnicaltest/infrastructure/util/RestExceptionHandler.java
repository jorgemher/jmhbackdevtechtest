package tmc.back.tech.test.backdevtechnicaltest.infrastructure.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.ServerWebExchange;

import java.net.ConnectException;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            NullPointerException.class,
            IllegalAccessException.class,
            ConnectException.class,
            HttpServerErrorException.class,
            HttpServerErrorException.InternalServerError.class,
            Exception.class
    })
    protected ResponseEntity<Object> handleInternalServerError (RuntimeException ex, ServerWebExchange webRequest){
        String bodyOfResponse = "There was an internal server error";
        log.debug("Internal server error handled - INTERNAL SERVER ERROR STATUS");
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest).block();
    }
}
