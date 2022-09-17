package com.mistela.gitrepos.service;

import com.mistela.gitrepos.dto.BranchDTO;
import com.mistela.gitrepos.dto.RepositoryDTO;
import com.mistela.gitrepos.dto.RepositoryResponse;
import com.mistela.gitrepos.mapper.RepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
@Service
public final class RestService {

    private static final String REPOSITORY_RESOURCE_URL = "https://api.github.com/users/%s/repos";
    private static final String BRANCH_RESOURCE_URL = "https://api.github.com/repos/%s/%s/branches";

    private final RestTemplate restTemplate;
    private final RepositoryMapper repositoryMapper;

    public Set<RepositoryResponse> listReposBy(String username) {
        Set<RepositoryDTO> forEntity = findReposWhichAreNotForks(format(REPOSITORY_RESOURCE_URL, username));
        Set<RepositoryResponse> repositoryResponses = new HashSet<>();

        for (RepositoryDTO repositoryDTO : forEntity) {
            Set<BranchDTO> branchBody = findBranches(format(BRANCH_RESOURCE_URL, repositoryDTO.getOwner().getLogin(), repositoryDTO.getName()));
            RepositoryResponse response = repositoryMapper.toRepositoryResponse(repositoryDTO);
            response.setBranches(branchBody);
            repositoryResponses.add(response);
        }
        return repositoryResponses;
    }

    private Set<RepositoryDTO> findReposWhichAreNotForks(String url) {
        return stream(requireNonNull(
                restTemplate
                        .getForEntity(url, RepositoryDTO[].class)
                        .getBody()))
                .filter(repositoryDTO -> !repositoryDTO.getIsFork())
                .collect(Collectors.toSet());
    }

    private Set<BranchDTO> findBranches(String url) {
        return stream(requireNonNull(
                restTemplate
                        .getForEntity(url, BranchDTO[].class)
                        .getBody()))
                .collect(Collectors.toSet());
    }
}
