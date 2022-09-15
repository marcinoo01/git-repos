package com.mistela.gitrepos.service;

import com.mistela.gitrepos.dto.RepositoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class RestService {

    private static final String RESOURCE_URL = "https://api.github.com/users/%s/repos";

    private final RestTemplate restTemplate;

    public Set<RepositoryDTO> listReposBy(String username) {
        ResponseEntity<RepositoryDTO[]> forEntity = restTemplate.getForEntity(String.format(RESOURCE_URL, username), RepositoryDTO[].class);
        Stream<RepositoryDTO> repositoryDTOS = Arrays.stream(Objects.requireNonNull(forEntity.getBody()));
        return repositoryDTOS.filter(repositoryDTO -> !repositoryDTO.getIsFork()).collect(Collectors.toSet());
    }
}
