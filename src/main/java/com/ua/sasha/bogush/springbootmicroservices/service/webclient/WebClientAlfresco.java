package com.ua.sasha.bogush.springbootmicroservices.service.webclient;

import com.ua.sasha.bogush.springbootmicroservices.configpojo.cmis.Alfresco;
import com.ua.sasha.bogush.springbootmicroservices.configpojo.webclient.WebClientCodecs;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * WebClient for connection on the API Alfresco
 *
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 09.12.2020
 */

@Service
public class WebClientAlfresco {
    private final Alfresco alfresco;
    private final WebClientCodecs webClientCodecs;

    /**
     * @param alfresco        Configure for connection
     * @param webClientCodecs Configure the codecs.
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 09.12.2020
     */
    public WebClientAlfresco(Alfresco alfresco, WebClientCodecs webClientCodecs) {
        this.alfresco = alfresco;
        this.webClientCodecs = webClientCodecs;
    }

    /**
     * @return WebClient Non-blocking, reactive client to perform HTTP requests, exposing a fluent, reactive API over underlying HTTP client libraries such as Reactor Netty.
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 09.12.2020
     */
    public WebClient getWebClient() {
        return WebClient
                .builder()
                .codecs(codecs -> codecs
                        .defaultCodecs()
                        .maxInMemorySize(webClientCodecs.getByteCount())
                ).baseUrl(alfresco.getHttpurl())
                .build();
    }
}
