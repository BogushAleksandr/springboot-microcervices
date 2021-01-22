package com.ua.sasha.bogush.springbootmicrocervices.configpojo.cmis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 8.12.2020
 */

@Configuration
@PropertySource("file:${SETTING_ASYNCH_REST_FUL}/alfresco.properties")
@ConfigurationProperties(prefix = "alfresco")
public class Alfresco {
    private String httpurl;
    private String username;
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
