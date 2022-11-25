package com.chomolungma.system.user.interfaces.mapstruct;


import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.chomolungma.system.user.interfaces.dto.UserDTO;
import com.chomolungma.system.user.interfaces.dto.UserFormDTO;
import com.chomolungma.system.user.interfaces.dto.UserSearchDTO;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserEntityMapStruct {
    UserEntityMapStruct INSTANCE = Mappers.getMapper(UserEntityMapStruct.class);

    @Mappings({
        @Mapping(target = "records", source = "list"),
        @Mapping(target = "page", source = "pageNum")
    })
    PageUserDTO toPageUserDTO(PageInfo<UserDTO> pageUsers);
    User toEntity(UserFormDTO userFormDTO);
    User toEntity(UserSearchDTO userSearchDTO);
    @Mappings({
            @Mapping(target = "deptId", source = "org.id"),
            @Mapping(target = "deptName", source = "org.name")
    })
    UserDTO toDTO(User user);

}
