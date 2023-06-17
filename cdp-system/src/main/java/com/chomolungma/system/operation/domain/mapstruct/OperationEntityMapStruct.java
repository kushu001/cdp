package com.chomolungma.system.operation.domain.mapstruct;

import com.chomolungma.system.operation.domain.entity.Operation;
import com.chomolungma.system.operation.infrastructure.dataobject.OperationDO;
import com.chomolungma.system.operation.interfaces.param.OperationDTO;
import com.chomolungma.system.operation.interfaces.param.OperationPageDTO;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
*  Automatically generated code by CDP-GENERATOR maven-plugin.
*  Thank you for your use.
*  Good Luck!
*/


@Mapper
public interface OperationEntityMapStruct {
    OperationEntityMapStruct INSTANCE = Mappers.getMapper(OperationEntityMapStruct.class);
    
    Operation toEntity(OperationDTO operationDTO);
    
    OperationDTO toDTO(Operation operation);
    
    @Mappings({
        @Mapping(target = "records", source = "list"),
        @Mapping(target = "page", source = "pageNum")
    })
    OperationPageDTO toOperationPageDTO(PageInfo<OperationDO> operationPageInfo);

}