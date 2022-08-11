package com.chomolungma.system.user.domain.repository;

import com.chomolungma.system.user.domain.repository.dataobject.UserOrgDO;
import com.chomolungma.system.user.domain.repository.mapper.UserMapper;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository{
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageUserDTO getUserByIds(List<Long> userIds, int current, int size) {
        PageHelper.startPage(current, size);
        List<UserOrgDO> userOrgDOS = userIds.size()==0? new ArrayList<>() : userMapper.pageUsersByIds(userIds);
        PageInfo<UserOrgDO> pageInfo = new PageInfo<>(userOrgDOS);
        PageHelper.clearPage();
        return UserAssembler.toPageUserDTO(pageInfo);
    }
}
