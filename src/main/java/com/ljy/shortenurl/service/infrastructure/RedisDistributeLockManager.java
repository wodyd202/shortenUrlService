package com.ljy.shortenurl.service.infrastructure;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class RedisDistributeLockManager implements DistributeLockManager {
    private final RedissonClient redissonClient;

    @Value("${redis.lock.shorten-url.key}")
    private String shortenUrlLockKey;

    @Override
    public boolean tryLock(String key) throws Exception {
        RLock lock = redissonClient.getLock(shortenUrlLockKey + key);
        try {
            if (!lock.tryLock(1, 5, TimeUnit.SECONDS)) {
                return false;
            }
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
        return true;
    }
}
