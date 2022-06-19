package com.ljy.shortenurl.service.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UrlInfo {
    private final String shortenUrl;
    private final String redirectUrl;

    protected UrlInfo() {
        shortenUrl = null;
        redirectUrl = null;
    }
}
