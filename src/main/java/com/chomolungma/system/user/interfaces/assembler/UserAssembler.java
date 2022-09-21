package com.chomolungma.system.user.interfaces.assembler;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.interfaces.dto.*;
import com.chomolungma.system.user.interfaces.mapstruct.UserEntityMapStruct;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class UserAssembler {
    public static UserEntity toUserEntity(UserSearchDTO userSearchDTO){
        return UserEntityMapStruct.INSTANCE.fromUserSearchDTO(userSearchDTO);
    }

    public static UserEntity toUserEntity(UserFormDTO userFormDTO){
        return UserEntityMapStruct.INSTANCE.toUserEntity(userFormDTO);
    }

    public static PageUserDTO toPageUserDTO(IPage<UserEntity> userEntity){
        return UserEntityMapStruct.INSTANCE.toPageUserDTO(userEntity);
    }

    public static PageUserDTO toPageUserDTO(PageInfo<UserDTO> userOrgDOPageInfo){
        return UserEntityMapStruct.INSTANCE.toPageUserDTO(userOrgDOPageInfo);
    }


    public static UserDTO fromUserEntity(UserEntity userEntity){
        return UserEntityMapStruct.INSTANCE.fromUserEntity(userEntity);
    }


    public static List<User> toDTO(List<UserEntity> userEntities){
        return UserEntityMapStruct.INSTANCE.toDTO(userEntities);
    }

    public static com.chomolungma.system.user.domain.entity.User toEntity(UserFormDTO userFormDTO){
        return UserEntityMapStruct.INSTANCE.toEntity(userFormDTO);
    }

    public static UserDTO toDTO(com.chomolungma.system.user.domain.entity.User user){
        return UserEntityMapStruct.INSTANCE.toDTO(user);
    }

    public static com.chomolungma.system.user.domain.entity.User toEntity(UserSearchDTO userSearchDTO){
        return UserEntityMapStruct.INSTANCE.toEntity(userSearchDTO);
    }

}
