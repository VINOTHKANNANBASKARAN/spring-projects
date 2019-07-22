package com.vk.rest.SpringBootRestFulService.Exception;

import com.vk.rest.SpringBootRestFulService.Beans.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
     ExceptionResponse exceptionResponse =    new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false
        ) );
     return ResponseEntity.status(HttpStatus.BAD_REQUEST)
             .body(exceptionResponse);
    }

    @ExceptionHandler({CustomerNotFoundException.class })
    public final ResponseEntity<Object> handleCusotmerNotFoundException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse =    new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false
        ) );
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exceptionResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse =    new ExceptionResponse(new Date(),
                ex.getMessage(),ex.getBindingResult().toString() );
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exceptionResponse);
    }
}
