package com.ljy.shortenurl.service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ShortenUrl {
    private final String path;
    private final String realPath;

    protected ShortenUrl() {
        path = null;
        realPath = null;
    }
}
