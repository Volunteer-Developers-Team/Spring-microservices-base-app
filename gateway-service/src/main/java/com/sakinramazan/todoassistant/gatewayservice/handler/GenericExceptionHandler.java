package com.sakinramazan.todoassistant.gatewayservice.handler;

import com.sakinramazan.todoassistant.gatewayservice.exception.NotValidUriException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GenericExceptionHandler {

    private Map<String, String> responseDetails;

    @ExceptionHandler({
            InvocationTargetException.class,
            NotValidUriException.class
    })
    public ResponseEntity<Object> exception(Exception exception) {
        buildResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(responseDetails, HttpStatus.BAD_REQUEST);
    }

    // If not found specific exception, use this as Internal server error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> default_exception(Exception exception) {
        buildResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(responseDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void buildResponse(String cause, HttpStatus status) {
        responseDetails = new HashMap<>();
        responseDetails.put("Cause", cause);
        responseDetails.put("Status", status.toString());
    }

}
