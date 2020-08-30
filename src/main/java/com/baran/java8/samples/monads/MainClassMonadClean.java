package com.baran.java8.samples.monads;

import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Slf4j
public class MainClassMonadClean {
    URI apiBaseURLFromEnv(String baseUrl) throws URISyntaxException {
        Optional<Try<URI, URISyntaxException>> apiBaseURL = Optional
                .ofNullable(baseUrl)
                .map(urlString -> Try.attempt(() -> new URI(urlString))
                );
        if (!apiBaseURL.isPresent()) {
            return null;
        }
        return apiBaseURL.get().orElseThrow();
    }

    public static void main(String[] args) {
        String str = "https://www.google.co.in/?gws_rd=ssl#"
                + "q=networking+in+java+geeksforgeeks"
                + "&spf=1496918039682";
        MainClassMonadClean mainClass = new MainClassMonadClean();
        try {
            URI uri = mainClass.apiBaseURLFromEnv(str);
            log.info("URI host is {}", uri.getHost());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


}
