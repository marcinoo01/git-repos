package com.mistela.gitrepos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RepositoryDTO {
    @JsonProperty(value = "full_name")
    private String fullName;
    @JsonProperty(value = "owner")
    private OwnerDTO owner;
    private String name;
    @JsonProperty(value = "branches_url")
    private String branchUrl;
    @JsonProperty(value = "fork")
    private Boolean isFork;
}
