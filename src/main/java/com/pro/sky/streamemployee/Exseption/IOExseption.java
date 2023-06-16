package com.pro.sky.streamemployee.Exseption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IOExseption extends RuntimeException{
    public IOExseption() {
    }

    public IOExseption(String message) {
        super(message);
    }

    public IOExseption(String message, Throwable cause) {
        super(message, cause);
    }

    public IOExseption(Throwable cause) {
        super(cause);
    }

    public IOExseption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
