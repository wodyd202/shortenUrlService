package com.ljy.shortenurl.service.presentation;

import com.ljy.shortenurl.service.application.ShortenUrlService;
import com.ljy.shortenurl.service.application.dto.CreateShortenUrlDto;
import com.ljy.shortenurl.service.application.resource.ShortenUrlResource;
import com.ljy.shortenurl.service.presentation.request.CreateShortenUrlRequest;
import com.ljy.shortenurl.service.presentation.respose.ShortenUrlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ShortenUrlController {
    private final ShortenUrlService shortenUrlService;

    @GetMapping("{shortenUrl}")
    public void redirectUrl(@PathVariable String shortenUrl, HttpServletResponse response) throws IOException {
        ShortenUrlResource shortenUrlResource = shortenUrlService.getShortenUrl(shortenUrl);
        response.sendRedirect(shortenUrlResource.getRedirectUrl());
    }

    @PostMapping
    public ShortenUrlResponse createShortenUrl(@Valid @RequestBody CreateShortenUrlRequest request) {
        CreateShortenUrlDto dto = new CreateShortenUrlDto(request.getRedirectUrl(), request.getType());
        ShortenUrlResource shortenUrl = shortenUrlService.createShortenUrl(dto, "creator");
        return ShortenUrlResponse.created(shortenUrl);
    }
}
