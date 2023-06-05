package com.pro.sky.streamemployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AllreadyAddedExseption extends RuntimeException {
    public AllreadyAddedExseption() {

    }

    public AllreadyAddedExseption(String message) {
        super(message);
    }

    public AllreadyAddedExseption(String message, Throwable cause) {
        super(message, cause);
    }

    public AllreadyAddedExseption(Throwable cause) {
        super(cause);
    }

    public AllreadyAddedExseption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
