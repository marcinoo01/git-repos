package com.mistela.gitrepos.model;

import java.util.Set;

public class Repository {
    private String fullName;
    private String name;
    private Set<Branch> branches;
    private Boolean isFork;
}
