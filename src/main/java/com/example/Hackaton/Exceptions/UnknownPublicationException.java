package com.example.Hackaton.Exceptions;

public class UnknownPublicationException extends RuntimeException {

    public UnknownPublicationException(String message) {
        super(message);
    }
}