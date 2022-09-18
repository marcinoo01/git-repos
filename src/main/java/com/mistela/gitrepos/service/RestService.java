package com.mistela.gitrepos.service;

import com.mistela.gitrepos.mapper.RepositoryMapper;
import com.mistela.gitrepos.model.Branch;
import com.mistela.gitrepos.model.Repository;
import com.mistela.gitrepos.model.RepositoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
@Service
public final class RestService {

    private static final String REPOSITORY_RESOURCE_URL = "https://api.github.com/users/%s/repos";
    private static final String BRANCH_RESOURCE_URL = "https://api.github.com/repos/%s/%s/branches";

    private final RestTemplate restTemplate;
    private final RepositoryMapper repositoryMapper;

    public Set<RepositoryResponse> listReposBy(String username) {
        Set<Repository> forEntity = findReposWhichAreNotForks(format(REPOSITORY_RESOURCE_URL, username));
        Set<RepositoryResponse> repositoryResponses = new HashSet<>();

        for (Repository repositoryDTO : forEntity) {
            Set<Branch> branchBody = findBranches(format(BRANCH_RESOURCE_URL,
                    repositoryDTO.getOwner().getLogin(), repositoryDTO.getName()));
            RepositoryResponse response = repositoryMapper.toRepositoryResponse(repositoryDTO);

            response.setBranches(branchBody);
            repositoryResponses.add(response);
        }
        return repositoryResponses;
    }

    private Set<Repository> findReposWhichAreNotForks(String url) {
        return Arrays.stream(requireNonNull(
                restTemplate
                        .getForEntity(url, Repository[].class)
                        .getBody()))
                .filter(repositoryDTO -> !repositoryDTO.getIsFork())
                .collect(Collectors.toSet());
    }

    private Set<Branch> findBranches(String url) {
        return Arrays.stream(requireNonNull(
                restTemplate
                        .getForEntity(url, Branch[].class)
                        .getBody()))
                .collect(Collectors.toSet());
    }
}
