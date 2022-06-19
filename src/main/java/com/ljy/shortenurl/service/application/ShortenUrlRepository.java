package com.ljy.shortenurl.service.application;

import com.ljy.shortenurl.service.model.ShortenUrl;

import java.util.Optional;

public interface ShortenUrlRepository {
    void save(ShortenUrl shortenUrl);
    Optional<ShortenUrl> findByShortenUrl(String shortenUrl);
}
