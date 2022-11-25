package com.chomolungma.system.user.interfaces.assembler;


import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.chomolungma.system.user.interfaces.dto.UserDTO;
import com.chomolungma.system.user.interfaces.dto.UserFormDTO;
import com.chomolungma.system.user.interfaces.dto.UserSearchDTO;
import com.chomolungma.system.user.interfaces.mapstruct.UserEntityMapStruct;
import com.github.pagehelper.PageInfo;


public class UserAssembler {

    public static PageUserDTO toPageUserDTO(PageInfo<UserDTO> userOrgDOPageInfo){
        return UserEntityMapStruct.INSTANCE.toPageUserDTO(userOrgDOPageInfo);
    }

    public static User toEntity(UserFormDTO userFormDTO){
        return UserEntityMapStruct.INSTANCE.toEntity(userFormDTO);
    }

    public static User toEntity(UserSearchDTO userSearchDTO){
        return UserEntityMapStruct.INSTANCE.toEntity(userSearchDTO);
    }

    public static UserDTO toDTO(User user){
        return UserEntityMapStruct.INSTANCE.toDTO(user);
    }

}
