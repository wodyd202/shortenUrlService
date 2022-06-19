package com.ljy.shortenurl.service.presentation.request;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateShortenUrlRequest {

    @NotBlank(message = "realPath는 필수 값 입니다.")
    private String realPath;
}
