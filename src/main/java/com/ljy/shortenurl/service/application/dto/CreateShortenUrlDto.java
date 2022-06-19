package com.ljy.shortenurl.service.application.dto;

import lombok.Getter;

@Getter
public class CreateShortenUrlDto {
    private final String targetUrl;

    public CreateShortenUrlDto(String targetUrl) {
        this.targetUrl = targetUrl;
    }
}
