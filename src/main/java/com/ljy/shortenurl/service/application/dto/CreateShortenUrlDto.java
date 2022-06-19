package com.ljy.shortenurl.service.application.dto;

import lombok.Getter;

@Getter
public class CreateShortenUrlDto {
    private final String realPath;

    public CreateShortenUrlDto(String realPath) {
        this.realPath = realPath;
    }
}
