package com.mistela.gitrepos.mapper;

import com.mistela.gitrepos.model.Repository;
import com.mistela.gitrepos.model.RepositoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RepositoryMapper {
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "owner", target = "owner")
    @Mapping(source = "name", target = "name")
    RepositoryResponse toRepositoryResponse(Repository repositoryDTO);
}
