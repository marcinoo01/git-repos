package com.mistela.gitrepos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Repository(@JsonProperty(value = "full_name")
                         String fullName,
                         @JsonProperty(value = "owner")
                         Owner owner,
                         String name,
                         @JsonProperty(value = "branch_url")
                         String branchUrl,
                         @JsonProperty(value = "fork")
                         Boolean isFork) {
}

