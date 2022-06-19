package com.ljy.shortenurl.service.application.dto;

import com.ljy.shortenurl.service.domain.ShortenUrlType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateShortenUrlDto {
    private final String targetUrl;
    private final ShortenUrlType type;
}
