package com.mistela.gitrepos.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.Duration;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class ConfigClass {

    private final static Duration DURATION_OF_CONNECT_TIMEOUT = Duration.ofMinutes(5);
    private final static Duration DURATION_OF_READ_TIMEOUT = Duration.ofMinutes(5);

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(DURATION_OF_CONNECT_TIMEOUT)
                .setReadTimeout(DURATION_OF_READ_TIMEOUT)
                .build();
    }
}
