package com.chomolungma.system.log.domain.repository;

import com.chomolungma.system.log.domain.repository.converter.LoginLogConverter;
import com.chomolungma.system.log.domain.repository.dataobject.LoginLogDO;
import com.chomolungma.system.log.domain.repository.mapper.LoginLogMapper;
import com.chomolungma.system.log.interfaces.assembler.LoginLogAssembler;
import com.chomolungma.system.log.interfaces.dto.LoginLogDTO;
import com.chomolungma.system.log.interfaces.dto.LoginLogPageDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginLogRepositoryImpl implements ILoginLogRepository{
    @Autowired
    private LoginLogMapper loginLogMapper;
    @Override
    public LoginLogPageDTO find(LoginLogDTO loginLogDTO) {
        PageHelper.startPage(loginLogDTO.getPage(), loginLogDTO.getLimit());
        LoginLogDO loginLogDO = LoginLogConverter.INSTANCE.toDO(loginLogDTO);
        List<LoginLogDO> list  = loginLogMapper.selectList(loginLogDO);
        PageInfo<LoginLogDO> pageInfo = new PageInfo<>(list);
        return LoginLogAssembler.INSTANCE.toPageDTO(pageInfo);
    }

    @Override
    public Void save(LoginLogDTO loginLogDTO) {
        LoginLogDO loginLogDO = LoginLogConverter.INSTANCE.toDO(loginLogDTO);
        loginLogMapper.insert(loginLogDO);
        return null;
    }
}
