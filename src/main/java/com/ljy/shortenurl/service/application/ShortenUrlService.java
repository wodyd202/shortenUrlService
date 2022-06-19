package com.ljy.shortenurl.service.application;

import com.ljy.shortenurl.service.application.dto.CreateShortenUrlDto;
import com.ljy.shortenurl.service.application.exception.ShortenUrlNotFoundException;
import com.ljy.shortenurl.service.application.resource.ShortenUrlResource;
import com.ljy.shortenurl.service.domain.RedirectHistory;
import com.ljy.shortenurl.service.domain.ShortenUrl;
import com.ljy.shortenurl.service.domain.UrlInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShortenUrlService {
    private final ShortenUrlFactory shortenUrlFactory;
    private final ShortenUrlRepository shortenUrlRepository;
    private final ShortenUrlInfoRepository shortenUrlInfoRepository;

    private final RedirectHistoryRepository redirectHistoryRepository;

    @Transactional(timeout = 3)
    public ShortenUrlResource createShortenUrl(CreateShortenUrlDto dto, String creator) {
        ShortenUrl shortenUrl = shortenUrlFactory.create(dto, creator);
        UrlInfo urlInfo = shortenUrl.getUrlInfo();

        saveShortenUrl(shortenUrl, urlInfo);
        return ShortenUrlResource.from(urlInfo);
    }

    private void saveShortenUrl(ShortenUrl shortenUrl, UrlInfo urlInfo) {
        shortenUrlRepository.save(shortenUrl);
        shortenUrlInfoRepository.save(urlInfo);
    }

    public ShortenUrlResource getShortenUrl(String shortenUrl) {
        UrlInfo urlInfo = shortenUrlInfoRepository.findByShortenUrl(shortenUrl)
                .orElseThrow(ShortenUrlNotFoundException::new);
        RedirectHistory redirectHistory = RedirectHistory.shortenUrlOf(shortenUrl);
        redirectHistoryRepository.save(redirectHistory);
        return ShortenUrlResource.from(urlInfo);
    }
}
