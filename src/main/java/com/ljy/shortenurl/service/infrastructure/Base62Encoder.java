package com.ljy.shortenurl.service.infrastructure;

import com.ljy.shortenurl.service.application.ShortenUrlPathCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Base62Encoder implements ShortenUrlPathCreator {
    private final RedisDistributeLockManager lockRepository;
    private final int RADIX = 62;
    private final String BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @Override
    public String create() {
        int retryCount = 3;
        while(retryCount > 0) {
            long standard = System.currentTimeMillis();
            StringBuilder builder = new StringBuilder();
            while(standard > 0) {
                builder.append(BASE62.charAt((int) (standard % RADIX)));
                standard /= RADIX;
            }
            try {
                if(lockRepository.tryLock(builder.toString())) {
                    return builder.toString();
                }
            } catch (Exception e) {
                log.error("try lock exception", e);
            }
            retryCount--;
        }

        throw new RuntimeException();
    }
}
