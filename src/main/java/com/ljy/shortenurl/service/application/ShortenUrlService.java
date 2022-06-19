package com.ljy.shortenurl.service.application;

import com.ljy.shortenurl.service.application.dto.CreateShortenUrlDto;
import com.ljy.shortenurl.service.application.exception.ShortenUrlNotFoundException;
import com.ljy.shortenurl.service.application.resource.ShortenUrlResource;
import com.ljy.shortenurl.service.model.ShortenUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShortenUrlService {
    private final ShortenUrlRepository shortenUrlRepository;

    @Value("${application.real-host}")
    private String applicationHost;

    public ShortenUrlResource createShortenUrl(CreateShortenUrlDto dto) {
        String realPath = dto.getRealPath();
        String shortenPath = applicationHost + UUID.randomUUID();

        ShortenUrl shortenUrl = new ShortenUrl(shortenPath, realPath);
        shortenUrlRepository.save(shortenUrl);
        return ShortenUrlResource.from(shortenUrl);
    }

    public ShortenUrlResource getShortenUrl(String shortenPath) {
        ShortenUrl shortenUrl = shortenUrlRepository.findByShortenUrl(applicationHost + shortenPath)
                .orElseThrow(ShortenUrlNotFoundException::new);
        return ShortenUrlResource.from(shortenUrl);
    }
}
