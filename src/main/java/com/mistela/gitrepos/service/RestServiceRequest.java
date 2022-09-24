package com.mistela.gitrepos.service;

import com.mistela.gitrepos.model.Branch;
import com.mistela.gitrepos.model.Repository;

import java.util.Set;

public interface RestServiceRequest {
    Set<Repository> findRepos(String username);

    Set<Branch> findBranches(Repository repository);
}
