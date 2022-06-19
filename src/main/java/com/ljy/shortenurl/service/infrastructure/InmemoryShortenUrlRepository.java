package com.ljy.shortenurl.service.infrastructure;

import com.ljy.shortenurl.service.application.ShortenUrlRepository;
import com.ljy.shortenurl.service.model.ShortenUrl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InmemoryShortenUrlRepository implements ShortenUrlRepository {
    private final Map<String, ShortenUrl> repo = new ConcurrentHashMap<>();

    @Override
    public void save(ShortenUrl shortenUrl) {
        repo.put(shortenUrl.getPath(), shortenUrl);
    }

    @Override
    public ShortenUrl findByShortenUrl(String shortenUrl) {
        return repo.get(shortenUrl);
    }
}
