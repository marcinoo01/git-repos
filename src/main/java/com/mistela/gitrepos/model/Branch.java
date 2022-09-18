package com.mistela.gitrepos.model;

import lombok.Data;

@Data
public class Branch {
    private String name;
    private Commit commit;
}
