package com.chomolungma.system.operation.infrastructure.converter;

import com.chomolungma.system.operation.domain.entity.Operation;
import com.chomolungma.system.operation.infrastructure.dataobject.OperationDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
*  Automatically generated code by CDP-GENERATOR maven-plugin.
*  Thank you for your use.
*  Good Luck!
*/

@Mapper
public interface OperationConverter {
    OperationConverter INSTANCE = Mappers.getMapper(OperationConverter.class);
    Operation toEntity(OperationDO operationDO);
    OperationDO toDO(Operation operation);
    List<Operation> toEntity(List<OperationDO> operationDOS);
}