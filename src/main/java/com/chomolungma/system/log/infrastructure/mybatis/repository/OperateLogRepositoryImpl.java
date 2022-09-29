package com.chomolungma.system.log.infrastructure.mybatis.repository;

import com.chomolungma.system.log.domain.repository.IOperateLogRepository;
import com.chomolungma.system.log.infrastructure.converter.OperateLogConverter;
import com.chomolungma.system.log.infrastructure.dataobject.OperateLogDO;
import com.chomolungma.system.log.infrastructure.mybatis.repository.mapper.OperateLogMapper;
import com.chomolungma.system.log.interfaces.assembler.OperateLogAssembler;
import com.chomolungma.system.log.interfaces.dto.OperateLogDTO;
import com.chomolungma.system.log.interfaces.dto.OperateLogPageDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperateLogRepositoryImpl implements IOperateLogRepository {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public OperateLogPageDTO find(int current, int size, String user, String requestMethod, String resourceName) {
        PageHelper.startPage(current, size);
        OperateLogDO operateLogDO = new OperateLogDO();
        operateLogDO.setUser(user);
        operateLogDO.setRequestMethod(requestMethod);
        operateLogDO.setResourceName(resourceName);
        List<OperateLogDO> list  = operateLogMapper.selectList(operateLogDO);
        PageInfo<OperateLogDO> pageInfo = new PageInfo<>(list);
        return OperateLogAssembler.INSTANCE.toPageDTO(pageInfo);
    }

    @Override
    public Void save(OperateLogDTO operateLogDTO) {
        OperateLogDO operateLogDO = OperateLogConverter.INSTANCE.toDO(operateLogDTO);
        operateLogMapper.insert(operateLogDO);
        return null;
    }
}
