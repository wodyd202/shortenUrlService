package com.ljy.shortenurl.service.application;

import com.ljy.shortenurl.service.model.ShortenUrl;

public interface ShortenUrlRepository {
    void save(ShortenUrl shortenUrl);
    ShortenUrl findByShortenUrl(String shortenUrl);
}
