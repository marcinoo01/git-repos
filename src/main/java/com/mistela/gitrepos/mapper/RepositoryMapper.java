package com.mistela.gitrepos.mapper;

import com.mistela.gitrepos.dto.RepositoryDTO;
import com.mistela.gitrepos.dto.RepositoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RepositoryMapper {
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "owner", target = "owner")
    @Mapping(source = "name", target = "name")
    RepositoryResponse toRepositoryResponse(RepositoryDTO repositoryDTO);
}
