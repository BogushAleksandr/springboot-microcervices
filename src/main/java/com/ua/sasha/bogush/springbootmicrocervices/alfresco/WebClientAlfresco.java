package com.ua.sasha.bogush.springbootmicrocervices.alfresco;

import com.ua.sasha.bogush.springbootmicrocervices.pojoconfig.Alfresco;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Service
public class WebClientAlfresco {
    private final Alfresco alfresco;

    public WebClientAlfresco(Alfresco alfresco) {
        this.alfresco = alfresco;
    }

    public WebClient getWebClient() {
        return WebClient
                .builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(2 * 1024 * 1024))
                .baseUrl(alfresco.getHttpurl())
                .build();
    }
}
