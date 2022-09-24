package com.mistela.gitrepos.service;

import com.mistela.gitrepos.model.RepositoryResponse;

import java.util.Set;

public interface RestServiceResponse {
    Set<RepositoryResponse> listReposBy(String username);
}
