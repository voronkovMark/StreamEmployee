package com.pro.sky.streamemployee.Exseption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundExseption extends RuntimeException {
    public EmployeeNotFoundExseption() {

    }

    public EmployeeNotFoundExseption(String message) {
        super(message);
    }

    public EmployeeNotFoundExseption(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoundExseption(Throwable cause) {
        super(cause);
    }

    public EmployeeNotFoundExseption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
