package com.ua.sasha.bogush.springbootmicrocervices.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 18.12.2020
 */

@Configuration
public class OpenApiConfig {
    private static final Logger logOpenApiConfig = LoggerFactory.getLogger(OpenApiConfig.class);
    @Bean
    public OpenAPI customOpenAPI() {
        logOpenApiConfig.info("Open REST API!");
        return new OpenAPI()
                .info(new Info()
                        .title("AsynchRestApi")
                        .version("1.0")
                        .description("This is a sample RestApi created using springdocs - a library for OpenAPI 3 with spring boot.")
                );
    }
}
