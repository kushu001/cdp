package com.chomolungma.system.log.infrastructure.mybatis.repository;

import com.chomolungma.system.log.domain.repository.ILoginLogRepository;
import com.chomolungma.system.log.infrastructure.mybatis.repository.mapper.LoginLogMapper;
import com.chomolungma.system.log.interfaces.assembler.LoginLogAssembler;
import com.chomolungma.system.log.interfaces.dto.LoginLogDTO;
import com.chomolungma.system.log.interfaces.dto.LoginLogPageDTO;
import com.chomolungma.system.log.infrastructure.converter.LoginLogConverter;
import com.chomolungma.system.log.infrastructure.dataobject.LoginLogDO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginLogRepositoryImpl implements ILoginLogRepository {
    @Autowired
    private LoginLogMapper loginLogMapper;
    @Override
    public LoginLogPageDTO find(int current, int size, String user, String client, String os) {
        PageHelper.startPage(current, size);
        LoginLogDO loginLogDO = new LoginLogDO();
        loginLogDO.setUser(user);
        loginLogDO.setClient(client);
        loginLogDO.setOs(os);
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
