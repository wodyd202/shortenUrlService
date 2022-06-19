package com.ljy.shortenurl.service.presentation;

import com.ljy.shortenurl.service.application.exception.ShortenUrlNotFoundException;
import com.ljy.shortenurl.service.presentation.respose.ShortenUrlResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShortenUrlExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ShortenUrlResponse handle(MethodArgumentNotValidException e) {
        return ShortenUrlResponse.badRequest(e.getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(ShortenUrlNotFoundException.class)
    public ShortenUrlResponse handle(ShortenUrlNotFoundException e) {
        return ShortenUrlResponse.notFound();
    }
}
