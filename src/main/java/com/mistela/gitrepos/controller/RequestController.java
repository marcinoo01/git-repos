package com.mistela.gitrepos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class RequestController {
    private static final String RESOURCE_URL = "https://api.github.com/users/%s/repos";
    private final RestTemplate restTemplate;

    @GetMapping(value = "/api/v1/{username}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String owner(@PathVariable String username) {
        return restTemplate.getForEntity(String.format(RESOURCE_URL, username), String.class).getBody();
    }
}
