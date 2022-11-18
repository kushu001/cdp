package com.chomolungma.system.user.interfaces.mapstruct;

import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.interfaces.dto.*;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserEntityMapStruct {
    UserEntityMapStruct INSTANCE = Mappers.getMapper(UserEntityMapStruct.class);

    UserEntity fromUserSearchDTO(UserSearchDTO userSearchDTO);
    @Mappings({
        @Mapping(target = "records", source = "list"),
        @Mapping(target = "page", source = "pageNum")
    })
    PageUserDTO toPageUserDTO(PageInfo<UserDTO> pageUsers);
    UserDTO fromUserEntity(UserEntity userEntity);

    List<User> toDTO(List<UserEntity> userEntities);

    com.chomolungma.system.user.domain.entity.User toEntity(UserFormDTO userFormDTO);

    UserDTO toDTO(com.chomolungma.system.user.domain.entity.User user);

    com.chomolungma.system.user.domain.entity.User toEntity(UserSearchDTO userSearchDTO);

}
