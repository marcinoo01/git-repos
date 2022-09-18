package com.mistela.gitrepos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Repository {
    @JsonProperty(value = "full_name")
    private String fullName;
    @JsonProperty(value = "owner")
    private Owner owner;
    private String name;
    @JsonProperty(value = "branch_url")
    private String branchUrl;
    @JsonProperty(value = "fork")
    private Boolean isFork;
}
