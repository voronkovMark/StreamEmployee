package com.pro.sky.streamemployee.Exseption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AllreadyAddedException extends RuntimeException {
    public AllreadyAddedException() {

    }

    public AllreadyAddedException(String message) {
        super(message);
    }

    public AllreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AllreadyAddedException(Throwable cause) {
        super(cause);
    }

    public AllreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
