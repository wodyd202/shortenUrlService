package com.ljy.shortenurl.service.application;

import com.ljy.shortenurl.service.domain.ShortenUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long> {
}
