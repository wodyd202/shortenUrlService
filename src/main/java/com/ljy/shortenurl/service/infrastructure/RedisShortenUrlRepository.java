package com.ljy.shortenurl.service.infrastructure;

import com.ljy.shortenurl.service.application.ShortenUrlInfoRepository;
import com.ljy.shortenurl.service.domain.UrlInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Optional;

@Repository
public class RedisShortenUrlRepository implements ShortenUrlInfoRepository {
    private final ValueOperations valueOperations;

    public RedisShortenUrlRepository(RedisTemplate redisTemplate) {
        this.valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void save(UrlInfo shortenUrl) {
        valueOperations.set(shortenUrl.getShortenUrl(), shortenUrl, Duration.ofMinutes(30));
    }

    @Override
    public Optional<UrlInfo> findByShortenUrl(String shortenUrl) {
        Object o = valueOperations.get(shortenUrl);
        if(o != null) {
            return Optional.of((UrlInfo) o);
        }
        return Optional.empty();
    }
}
