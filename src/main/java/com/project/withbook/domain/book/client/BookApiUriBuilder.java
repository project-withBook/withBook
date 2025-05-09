package com.project.withbook.domain.book.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class BookApiUriBuilder {

    private static final int DEFAULT_START_INDEX = 1;
    private static final int DEFAULT_MAX_RESULTS = 20;
    private static final String DEFAULT_OUTPUT = "xml";
    private static final String DEFAULT_ITEM_ID_TYPE = "isbn13";
    private static final String DEFAULT_COVER_SIZE = "big";

    @Value("${aladin.base.url}")
    private String aladinBaseUrl;

    @Value("${aladin.search.endpoint}")
    private String searchEndPoint;

    @Value("${aladin.lookup.endpoint}")
    private String lookupEndpoint;

    @Value("${aladin.ttb.key}")
    private String ttbKey;

    @Value("${aladin.api.version}")
    private String apiVersion;

    public URI buildUri(String isbn) {
        return UriComponentsBuilder.fromUriString(aladinBaseUrl + lookupEndpoint)
                .queryParam("ttbkey", ttbKey)
                .queryParam("itemIdType", DEFAULT_ITEM_ID_TYPE)
                .queryParam("itemId", isbn)
                .queryParam("output", DEFAULT_OUTPUT)
                .queryParam("version", apiVersion)
                .queryParam("cover", DEFAULT_COVER_SIZE)
                .build().encode().toUri();
    }

    public URI buildUri(String query, String queryType) {
        return UriComponentsBuilder.fromUriString(aladinBaseUrl + searchEndPoint)
                .queryParam("ttbkey", ttbKey)
                .queryParam("query", query)
                .queryParam("queryType", queryType)
                .queryParam("maxResults", DEFAULT_MAX_RESULTS)
                .queryParam("start", DEFAULT_START_INDEX)
                .queryParam("output", DEFAULT_OUTPUT)
                .queryParam("version", apiVersion)
                .build().encode().toUri();
    }

}
