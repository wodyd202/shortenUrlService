package com.ljy.shortenurl.service.presentation;

import com.ljy.shortenurl.service.application.ShortenUrlService;
import com.ljy.shortenurl.service.application.dto.CreateShortenUrlDto;
import com.ljy.shortenurl.service.application.resource.ShortenUrlResource;
import com.ljy.shortenurl.service.presentation.request.CreateShortenUrlRequest;
import com.ljy.shortenurl.service.presentation.respose.ShortenUrlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ShortenUrlController {
    private final ShortenUrlService shortenUrlService;

    @GetMapping("{shortenUrl}")
    public void redirectUrl(@PathVariable String shortenUrl, HttpServletResponse httpServletResponse) throws IOException {
        String shortenPath = shortenUrlService.getRealPath(shortenUrl).getRealPath();
        httpServletResponse.sendRedirect(shortenPath);
    }

    @PostMapping("/api/v1/shorten-url")
    public ShortenUrlResponse createShortenUrl(@Valid @RequestBody CreateShortenUrlRequest request) {
        CreateShortenUrlDto dto = new CreateShortenUrlDto(request.getRealPath());
        ShortenUrlResource shortenUrl = shortenUrlService.createShortenUrl(dto);
        return ShortenUrlResponse.created(shortenUrl);
    }
}
