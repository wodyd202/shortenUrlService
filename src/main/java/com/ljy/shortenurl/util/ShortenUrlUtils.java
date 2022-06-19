package com.ljy.shortenurl.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShortenUrlUtils {
    public static String HOST;

    public ShortenUrlUtils(@Value("${application.real-host}") String HOST) {
        this.HOST = HOST;
    }
}
