package com.ljy.shortenurl.service.application;

import com.ljy.shortenurl.service.application.dto.CreateShortenUrlDto;
import com.ljy.shortenurl.service.domain.ShortenUrl;
import com.ljy.shortenurl.service.domain.ShortenUrlType;
import com.ljy.shortenurl.service.domain.UrlInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShortenUrlFactory {
    private final ShortenUrlPathCreator pathCreator;

    public ShortenUrl create(CreateShortenUrlDto dto, String creator) {
        String shortenUrlPath = pathCreator.create();
        UrlInfo urlInfo = new UrlInfo(shortenUrlPath, dto.getTargetUrl());
        return new ShortenUrl(dto.getType(), urlInfo, creator);
    }
}
