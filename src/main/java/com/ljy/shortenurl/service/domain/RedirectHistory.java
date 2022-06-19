package com.ljy.shortenurl.service.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RedirectHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortenUrl;

    private LocalDateTime redirectDateTime;

    private RedirectHistory(String shortenUrl) {
        this.shortenUrl = shortenUrl;
        this.redirectDateTime = LocalDateTime.now();
    }

    public static RedirectHistory shortenUrlOf(String shortenUrl) {
        return new RedirectHistory(shortenUrl);
    }
}
