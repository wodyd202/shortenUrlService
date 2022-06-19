package com.ljy.shortenurl.service.application;

import com.ljy.shortenurl.service.domain.UrlInfo;

import java.util.Optional;

public interface ShortenUrlInfoRepository {
    void save(UrlInfo shortenUrl);
    Optional<UrlInfo> findByShortenUrl(String shortenUrl);
}
