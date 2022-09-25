package com.mistela.gitrepos.service;

import com.mistela.gitrepos.model.Branch;
import com.mistela.gitrepos.model.Repository;
import com.mistela.gitrepos.model.RepositoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public final class RestServiceResponseImpl implements RestServiceResponse {

    private final RestServiceRequest restServiceRequest;

    @Override
    public Set<RepositoryResponse> listReposBy(String username) {

        final Set<Repository> reposWhichAreNotForks = findReposWhichAreNotForks(username);
        final Set<RepositoryResponse> repositoryResponses = new HashSet<>();

        reposWhichAreNotForks
                .forEach(repository -> {
                            Set<Branch> branchBody = restServiceRequest.findBranches(repository);
                            RepositoryResponse response = new RepositoryResponse(repository.fullName(), repository.name(), repository.owner(), branchBody);
                            repositoryResponses.add(response);
                        }
                );

        return repositoryResponses;
    }

    private Set<Repository> findReposWhichAreNotForks(String username) {
        return restServiceRequest
                .findRepos(username)
                .stream()
                .filter(repository -> !repository.isFork())
                .collect(Collectors.toSet());
    }
}
