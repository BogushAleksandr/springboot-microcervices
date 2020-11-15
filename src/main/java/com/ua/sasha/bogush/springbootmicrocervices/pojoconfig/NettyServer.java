package com.ua.sasha.bogush.springbootmicrocervices.pojoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Configuration
@PropertySource("file:${NETTY_CONFIG}/netty.properties")
public class NettyServer {
    @Value("${port}")
    private int port;
    @Value("${ipadress}")
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
