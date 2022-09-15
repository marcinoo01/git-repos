package com.mistela.gitrepos.controller;

import com.mistela.gitrepos.dto.RepositoryDTO;
import com.mistela.gitrepos.service.RestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.Set;

@RestController
@RequiredArgsConstructor
public class RequestController {

    private final RestService restService;

    @GetMapping(value = "/api/v1/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<RepositoryDTO>> owner(@PathVariable String username) {
        return ResponseEntity.ok(restService.listReposBy(username));
    }
}
