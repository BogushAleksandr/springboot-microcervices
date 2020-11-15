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
@PropertySource("file:${ALFRESCO_CONFIG}/alfresco.properties")
public class Alfresco {
    @Value("${httpurl}")
    private String httpurl;
    @Value("${login}")
    private String username;
    @Value("${password}")
    private String password;

    public String getHttpurl() {
        return httpurl;
    }

    public void setHttpurl(String httpurl) {
        this.httpurl = httpurl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
