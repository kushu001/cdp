package com.chomolungma.system.operation.infrastructure.mybatis.repository.mapper;

import com.chomolungma.system.operation.infrastructure.dataobject.OperationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
*  Automatically generated code by CDP-GENERATOR maven-plugin.
*  Thank you for your use.
*  Good Luck!
*/

@Mapper
public interface OperationMapper {

    List<OperationDO> selectLists(OperationDO operationDO);
    OperationDO selectById(Long id);
    int insert(OperationDO operationDO);
    int updateById(OperationDO operationDO);
    void deleteBatchIds(List<String> ids);

}
