package com.ua.sasha.bogush.springbootmicrocervices.configpojo.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 8.12.2020
 */

@Configuration
@PropertySource("file:${WORK_ALF}/netty.properties")
@ConfigurationProperties(prefix = "netty")
public class Netty {
    private int port;
    private String ipadress;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIpadress() {
        return ipadress;
    }

    public void setIpadress(String ipadress) {
        this.ipadress = ipadress;
    }
}

