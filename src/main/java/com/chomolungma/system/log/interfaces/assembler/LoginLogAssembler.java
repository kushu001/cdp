package com.chomolungma.system.log.interfaces.assembler;

import com.chomolungma.system.log.domain.entity.LoginLogEntity;
import com.chomolungma.system.log.domain.repository.dataobject.LoginLogDO;
import com.chomolungma.system.log.interfaces.dto.LoginLogDTO;
import com.chomolungma.system.log.interfaces.dto.LoginLogPageDTO;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoginLogAssembler {
    LoginLogAssembler INSTANCE = Mappers.getMapper(LoginLogAssembler.class);

    LoginLogEntity toEntity(LoginLogDTO loginLogDTO);

    LoginLogDTO toDTO(LoginLogEntity loginLogEntity);

    @Mappings({
            @Mapping(target = "records", source = "list"),
            @Mapping(target = "page", source = "pageNum")
    })
    LoginLogPageDTO toPageDTO(PageInfo<LoginLogDO> pageInfo);
}
