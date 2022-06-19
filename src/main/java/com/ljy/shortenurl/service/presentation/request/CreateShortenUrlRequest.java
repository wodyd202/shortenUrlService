package com.ljy.shortenurl.service.presentation.request;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class CreateShortenUrlRequest {

    @NotBlank(message = "realPath는 필수 값 입니다.")
    @Pattern(regexp = "(http(s)?:\\/\\/)", message = "target url은 http:// 혹은 https://로 시작하는 값이여야 합니다.")
    private String targetUrl;
}
