package com.chomolungma.system.user.infrastructure.converter;

import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.infrastructure.dataobject.UserDO;
import com.chomolungma.system.user.interfaces.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDO toDO(User user);

    User toEntity(UserDO userDO);

    UserDTO toDTO(UserDO userDO);

}
