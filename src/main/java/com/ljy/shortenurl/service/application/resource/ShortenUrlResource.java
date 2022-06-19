package com.ljy.shortenurl.service.application.resource;

import com.ljy.shortenurl.service.model.ShortenUrl;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShortenUrlResource {
    private final String realPath;
    private final String shortenUrl;
    private final LocalDateTime redirectDate;

    private ShortenUrlResource(ShortenUrl shortenUrl) {
        this.realPath = shortenUrl.getTargetUrl();
        this.shortenUrl = shortenUrl.getUrl();
        this.redirectDate = LocalDateTime.now();
    }

    public static ShortenUrlResource from(ShortenUrl shortenUrl) {
        return new ShortenUrlResource(shortenUrl);
    }
}
