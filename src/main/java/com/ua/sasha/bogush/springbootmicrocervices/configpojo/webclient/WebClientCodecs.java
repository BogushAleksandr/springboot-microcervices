package com.ua.sasha.bogush.springbootmicrocervices.configpojo.webclient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 09.12.2020
 */

@Configuration
@PropertySource("file:${SETTING_ASYNCH_REST_FUL}/codecs.properties")
@ConfigurationProperties(prefix = "codecs")
public class WebClientCodecs {
    private int byteCount;

    public int getByteCount() {
        return byteCount;
    }

    public void setByteCount(int byteCount) {
        this.byteCount = byteCount;
    }
}
