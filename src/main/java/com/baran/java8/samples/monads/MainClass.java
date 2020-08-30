package com.baran.java8.samples.monads;

import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
@Slf4j
public class MainClass {
    URI apiBaseURLFromEnv(String baseUrl) throws URISyntaxException {
        Optional<URI> apiBaseURL;
        try {
            apiBaseURL = Optional
                    .ofNullable(baseUrl)
                    .map(baseUrlString -> {
                        try {
                            return new URI(baseUrlString);
                        } catch (URISyntaxException e) {
                            // wrap as unchecked exception, catch outside of lambda
                            throw new RuntimeException("uri parsing error", e);
                        }
                    });
        } catch (RuntimeException e) {
            // catch and re-throw the wrapped URISyntaxException
            if (e.getCause() instanceof URISyntaxException) {
                throw (URISyntaxException) e.getCause();
            } else {
                // something else weird happened, rethrow
                throw e;
            }
        }
        return apiBaseURL.orElse(null);
    }

    public static void main(String[] args) {
        String str = "https://www.google.co.in/?gws_rd=ssl#"
                + "q=networking+in+java+geeksforgeeks"
                +"&spf=1496918039682";
        MainClass mainClass = new MainClass();
        try {
            URI uri = mainClass.apiBaseURLFromEnv(str);
            log.info("URI host is {}",uri.getHost());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


}
