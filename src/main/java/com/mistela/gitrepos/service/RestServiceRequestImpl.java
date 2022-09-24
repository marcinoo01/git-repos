package com.mistela.gitrepos.service;


import com.mistela.gitrepos.model.Branch;
import com.mistela.gitrepos.model.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor
public class RestServiceRequestImpl implements RestServiceRequest {

    private static final String REPOSITORY_RESOURCE_URL = "https://api.github.com/users/%s/repos";
    private static final String BRANCH_RESOURCE_URL = "https://api.github.com/repos/%s/%s/branches";

    private final RestTemplate restTemplate;

    @Override
    public Set<Repository> findRepos(String username) {
        return Arrays
                .stream(requireNonNull(
                        restTemplate
                                .getForEntity(String.format(REPOSITORY_RESOURCE_URL, username), Repository[].class)
                                .getBody()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Branch> findBranches(Repository repository) {
        return Arrays
                .stream(requireNonNull(
                        restTemplate
                                .getForEntity(String.format(BRANCH_RESOURCE_URL, repository.owner().login(), repository.name()), Branch[].class)
                                .getBody()))
                .collect(Collectors.toSet());
    }
}