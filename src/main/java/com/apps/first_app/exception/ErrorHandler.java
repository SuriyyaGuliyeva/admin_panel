/*
package com.apps.first_app.exception;

import com.apps.first_app.repository.RestErrorResponse;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public RestErrorResponse handleException(NotFoundException e) {
        System.out.println("not found exception");
        return new RestErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
*/
