package com.pro.sky.streamemployee.Exseption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RenameException extends RuntimeException{
    public RenameException() {
    }

    public RenameException(String message) {
        super(message);
    }

    public RenameException(String message, Throwable cause) {
        super(message, cause);
    }

    public RenameException(Throwable cause) {
        super(cause);
    }

    public RenameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
