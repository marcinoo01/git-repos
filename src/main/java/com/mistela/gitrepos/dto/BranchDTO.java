package com.mistela.gitrepos.dto;

import lombok.Data;

@Data
public class BranchDTO {
    private String name;
    private CommitDTO commit;
}
