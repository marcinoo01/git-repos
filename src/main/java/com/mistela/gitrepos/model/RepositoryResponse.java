package com.mistela.gitrepos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record RepositoryResponse(@JsonProperty(value = "full_name", index = 0)
                                 String fullName,
                                 @JsonProperty(index = 1)
                                 String name,
                                 @JsonProperty(value = "owner", index = 2)
                                 Owner owner,
                                 @JsonProperty(index = 3)
                                 Set<Branch> branches) {
}
