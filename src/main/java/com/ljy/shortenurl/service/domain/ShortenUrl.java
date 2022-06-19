package com.ljy.shortenurl.service.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShortenUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ShortenUrlType type;

    @Embedded
    private UrlInfo urlInfo;

    private String creator;

    private LocalDateTime createDateTime;

    private LocalDateTime expireDateTime;

    public ShortenUrl(ShortenUrlType type, UrlInfo urlInfo, String creator) {
        this.type = type;
        this.creator = creator;
        this.urlInfo = urlInfo;
        this.createDateTime = LocalDateTime.now();
        this.expireDateTime = createDateTime.plusMinutes(30);
    }
}
