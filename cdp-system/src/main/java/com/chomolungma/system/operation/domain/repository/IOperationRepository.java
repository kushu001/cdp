package com.chomolungma.system.operation.domain.repository;

import com.chomolungma.system.operation.domain.entity.Operation;
import com.chomolungma.system.operation.infrastructure.dataobject.OperationDO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
*  Automatically generated code by CDP-GENERATOR maven-plugin.
*  Thank you for your use.
*  Good Luck!
*/


public interface IOperationRepository {
    void save(Operation operation);
    void remove(List<String> ids);
    Operation find(Long id);
    PageInfo<OperationDO> findPageList(Operation operation, int current, int size);
}