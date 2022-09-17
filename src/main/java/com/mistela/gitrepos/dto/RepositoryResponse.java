package com.mistela.gitrepos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class RepositoryResponse {
    @JsonProperty(value = "full_name", index = 0)
    private String fullName;
    @JsonProperty(index = 1)
    private String name;
    @JsonProperty(value = "owner", index = 2)
    private OwnerDTO owner;
    @JsonProperty(index = 3)
    private Set<BranchDTO> branches;
}
