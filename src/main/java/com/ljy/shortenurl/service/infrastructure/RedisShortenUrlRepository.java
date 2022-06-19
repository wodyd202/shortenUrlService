package com.ljy.shortenurl.service.infrastructure;

import com.ljy.shortenurl.service.application.ShortenUrlRepository;
import com.ljy.shortenurl.service.model.ShortenUrl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
public class RedisShortenUrlRepository implements ShortenUrlRepository {
    private final ValueOperations valueOperations;

    public RedisShortenUrlRepository(RedisTemplate redisTemplate) {
        this.valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void save(ShortenUrl shortenUrl) {
        valueOperations.set(shortenUrl.getPath(), shortenUrl, Duration.ofMinutes(30));
    }

    @Override
    public ShortenUrl findByShortenUrl(String shortenUrl) {
        return (ShortenUrl) valueOperations.get(shortenUrl);
    }
}
