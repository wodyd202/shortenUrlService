package com.ljy.shortenurl.service.application.resource;

import com.ljy.shortenurl.service.domain.UrlInfo;
import com.ljy.shortenurl.util.ShortenUrlUtils;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShortenUrlResource {
    private final String redirectUrl;
    private final String shortenUrl;
    private final LocalDateTime redirectDate;

    private ShortenUrlResource(UrlInfo shortenUrl) {
        this.redirectUrl = shortenUrl.getRedirectUrl();
        this.shortenUrl = ShortenUrlUtils.HOST + shortenUrl.getShortenUrl();
        this.redirectDate = LocalDateTime.now();
    }

    public static ShortenUrlResource from(UrlInfo urlInfo) {
        return new ShortenUrlResource(urlInfo);
    }
}
