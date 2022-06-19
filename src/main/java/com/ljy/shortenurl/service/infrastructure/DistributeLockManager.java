package com.ljy.shortenurl.service.infrastructure;

public interface DistributeLockManager {
    boolean tryLock(String key) throws Exception;
}
