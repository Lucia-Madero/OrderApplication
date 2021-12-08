package com.switchfully.orderapplication.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnknownUserException extends RuntimeException {
    public UnknownUserException() {super("This user does not exist");}
}
