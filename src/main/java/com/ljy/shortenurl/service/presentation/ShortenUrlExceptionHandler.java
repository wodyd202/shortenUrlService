package com.ljy.shortenurl.service.presentation;

import com.ljy.shortenurl.service.application.exception.ShortenUrlNotFoundException;
import com.ljy.shortenurl.service.presentation.respose.ShortenUrlResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShortenUrlExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ShortenUrlResponse handle(MethodArgumentNotValidException e) {
        return ShortenUrlResponse.badRequest(e.getAllErrors().get(0).getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ShortenUrlNotFoundException.class)
    public void handle(ShortenUrlNotFoundException e) {}
}
