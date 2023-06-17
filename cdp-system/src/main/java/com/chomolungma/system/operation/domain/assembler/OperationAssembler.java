package com.chomolungma.system.operation.domain.assembler;

import com.chomolungma.system.operation.domain.entity.Operation;
import com.chomolungma.system.operation.domain.mapstruct.OperationEntityMapStruct;
import com.chomolungma.system.operation.infrastructure.dataobject.OperationDO;
import com.chomolungma.system.operation.interfaces.param.OperationDTO;
import com.chomolungma.system.operation.interfaces.param.OperationPageDTO;
import com.github.pagehelper.PageInfo;

/**
*  Automatically generated code by CDP-GENERATOR maven-plugin.
*  Thank you for your use.
*  Good Luck!
*/

public class OperationAssembler {
    public static Operation toEntity(OperationDTO operationDTO){
        return OperationEntityMapStruct.INSTANCE.toEntity(operationDTO);
    }

    public static OperationDTO toDTO(Operation operation){
        return OperationEntityMapStruct.INSTANCE.toDTO(operation);
    }

    public static OperationPageDTO toOperationPageDTO(PageInfo<OperationDO> page){
        return OperationEntityMapStruct.INSTANCE.toOperationPageDTO(page);
    }
}
