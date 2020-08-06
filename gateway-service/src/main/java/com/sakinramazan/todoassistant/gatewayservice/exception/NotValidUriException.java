package com.sakinramazan.todoassistant.gatewayservice.exception;

public class NotValidUriException extends RuntimeException {
    public NotValidUriException(String message) {
        super("Url is not valid [ " + message + " ]");
    }
}
