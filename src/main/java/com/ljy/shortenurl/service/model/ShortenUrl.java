package com.ljy.shortenurl.service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ShortenUrl {
    private final String url;
    private final String targetUrl;

    protected ShortenUrl() {
        url = null;
        targetUrl = null;
    }
}
