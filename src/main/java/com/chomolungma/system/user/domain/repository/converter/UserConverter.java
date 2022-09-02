package com.chomolungma.system.user.domain.repository.converter;

import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.repository.dataobject.UserDO;
import com.chomolungma.system.user.domain.repository.dataobject.UserOrgDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDO toDO(UserEntity userEntity);

    List<UserEntity> toEntity(List<UserOrgDO> userOrgDOS);
}
