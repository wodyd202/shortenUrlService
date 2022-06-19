package com.ljy.shortenurl.service.presentation.respose;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ShortenUrlResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Object data;
    private final int status;
    private final boolean success;

    private ShortenUrlResponse(Object data, HttpStatus status) {
        this.data = data;
        this.status = status.value();
        this.success = this.status >= 200 && this.status < 400;
    }

    public static ShortenUrlResponse badRequest(String message) {
        return new ShortenUrlResponse(message, HttpStatus.BAD_REQUEST);
    }

    public static ShortenUrlResponse created(Object data) {
        return new ShortenUrlResponse(data, HttpStatus.CREATED);
    }

    public static ShortenUrlResponse notFound() {
        return new ShortenUrlResponse(null, HttpStatus.NOT_FOUND);
    }
}
