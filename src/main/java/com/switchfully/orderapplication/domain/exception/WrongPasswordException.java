package com.switchfully.orderapplication.domain.exception;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String message) {super(message);}
}
