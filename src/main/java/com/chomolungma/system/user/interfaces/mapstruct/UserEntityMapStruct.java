package com.chomolungma.system.user.interfaces.mapstruct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.chomolungma.system.user.interfaces.dto.UserDTO;
import com.chomolungma.system.user.interfaces.dto.UserFormDTO;
import com.chomolungma.system.user.interfaces.dto.UserSearchDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapStruct {
    UserEntityMapStruct INSTANCE = Mappers.getMapper(UserEntityMapStruct.class);

    UserEntity fromUserSearchDTO(UserSearchDTO userSearchDTO);

    PageUserDTO toPageUserDTO(IPage<UserEntity> pageUsers);

    UserEntity toUserEntity(UserFormDTO userFormDTO);

    UserDTO fromUserEntity(UserEntity userEntity);

}
