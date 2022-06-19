package com.ljy.shortenurl.service.infrastructure;

import com.ljy.shortenurl.service.application.ShortenUrlRepository;
import com.ljy.shortenurl.service.model.ShortenUrl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Optional;

@Repository
public class RedisShortenUrlRepository implements ShortenUrlRepository {
    private final ValueOperations valueOperations;

    public RedisShortenUrlRepository(RedisTemplate redisTemplate) {
        this.valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void save(ShortenUrl shortenUrl) {
        valueOperations.set(shortenUrl.getUrl(), shortenUrl, Duration.ofMinutes(30));
    }

    @Override
    public Optional<ShortenUrl> findByShortenUrl(String shortenUrl) {
        Object o = valueOperations.get(shortenUrl);
        if(o != null) {
            return Optional.of((ShortenUrl) o);
        }
        return Optional.empty();
    }
}
