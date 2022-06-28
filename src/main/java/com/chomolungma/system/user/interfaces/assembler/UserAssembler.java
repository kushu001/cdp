package com.chomolungma.system.user.interfaces.assembler;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.chomolungma.system.user.interfaces.dto.UserDTO;
import com.chomolungma.system.user.interfaces.dto.UserFormDTO;
import com.chomolungma.system.user.interfaces.dto.UserSearchDTO;
import com.chomolungma.system.user.interfaces.mapstruct.UserEntityMapStruct;

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

    public static UserDTO fromUserEntity(UserEntity userEntity){
        return UserEntityMapStruct.INSTANCE.fromUserEntity(userEntity);
    }

}
