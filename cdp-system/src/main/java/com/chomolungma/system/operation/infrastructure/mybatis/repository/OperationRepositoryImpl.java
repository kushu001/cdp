package com.chomolungma.system.operation.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.operation.domain.entity.Operation;
import com.chomolungma.system.operation.domain.repository.IOperationRepository;
import com.chomolungma.system.operation.infrastructure.converter.OperationConverter;
import com.chomolungma.system.operation.infrastructure.dataobject.OperationDO;
import com.chomolungma.system.operation.infrastructure.mybatis.repository.mapper.OperationMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import java.util.List;

/**
*  Automatically generated code by CDP-GENERATOR maven-plugin.
*  Thank you for your use.
*  Good Luck!
*/


@Repository
public class OperationRepositoryImpl implements IOperationRepository {

    private final OperationMapper operationMapper;

    public OperationRepositoryImpl(OperationMapper operationMapper){
        this.operationMapper = operationMapper;
    }
    @Override
    public void save(Operation operation) {
        OperationDO operationDO = OperationConverter.INSTANCE.toDO(operation);
        if (StringUtils.isEmpty(operationDO.getId())){
            operationMapper.insert(operationDO);
        }else{
            operationMapper.updateById(operationDO);
        }
    }

    @Override
    public void remove(List<String> ids) {

        operationMapper.deleteBatchIds(ids);

    }

    @Override
    public Operation find(Long id) {

        return OperationConverter.INSTANCE.toEntity(operationMapper.selectById(id));

    }

    @Override
    public PageInfo<OperationDO> findPageList(Operation operation, int current, int size) {

        OperationDO operationDO = OperationConverter.INSTANCE.toDO(operation);

        PageHelper.startPage(current, size);

        List<OperationDO> operations = operationMapper.selectLists(operationDO);

        PageInfo<OperationDO> pageInfo = new PageInfo<>(operations);

        return pageInfo;

    }
}
