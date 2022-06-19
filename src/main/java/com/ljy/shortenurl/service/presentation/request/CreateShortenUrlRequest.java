package com.ljy.shortenurl.service.presentation.request;

import com.ljy.shortenurl.service.domain.ShortenUrlType;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class CreateShortenUrlRequest {

    @NotBlank(message = "realPath는 필수 값 입니다.")
    @URL(message = "올바른 redirect url을 입력해주세요.")
    private String redirectUrl;

    @NotNull(message = "type은 필수 값 입니다.")
    private ShortenUrlType type;
}
