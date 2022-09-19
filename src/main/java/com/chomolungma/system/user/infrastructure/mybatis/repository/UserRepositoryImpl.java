package com.chomolungma.system.user.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.infrastructure.mybatis.repository.mapper.OrgMapper;
import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.repository.IUserRepository;
import com.chomolungma.system.user.infrastructure.converter.UserConverter;
import com.chomolungma.system.user.infrastructure.dataobject.OrgUserDO;
import com.chomolungma.system.user.infrastructure.dataobject.UserDO;
import com.chomolungma.system.user.infrastructure.mybatis.repository.mapper.OrgUserMapper;
import com.chomolungma.system.user.infrastructure.mybatis.repository.mapper.UserMapper;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.chomolungma.system.user.interfaces.dto.UserDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrgUserMapper orgUserMapper;
    @Autowired
    private OrgMapper orgMapper;


    @Override
    public PageUserDTO getUserByIds(String code, int current, int size) {
        List<OrgDO> orgDOS = orgMapper.selectList(new QueryWrapper<OrgDO>().likeRight("code", code));
        List<OrgUserDO> orgUserDOS = orgUserMapper.selectList(new QueryWrapper<OrgUserDO>().in("org_id", orgDOS.stream().map(OrgDO::getId).collect(Collectors.toList())));
        List<Long> userIds = orgUserDOS.stream().map(OrgUserDO::getUserId).collect(Collectors.toList());
        PageHelper.startPage(current, size);
        List<UserDTO> userOrgDOS = userIds.size()==0? new ArrayList<>() : userMapper.pageUsersByIds(userIds);
        PageInfo<UserDTO> pageInfo = new PageInfo<>(userOrgDOS);
        PageHelper.clearPage();
        return UserAssembler.toPageUserDTO(pageInfo);
    }

    @Override
    public List<UserEntity> getUsers(String code, UserEntity userEntity) {
        return UserConverter.INSTANCE.toEntity(userMapper.selectUsersByCondition(code, UserConverter.INSTANCE.toDO(userEntity)));
    }

    @Override
    public void save(User user) {
        // 转换成DO
        UserDO userDO = UserConverter.INSTANCE.toDO(user);
        // 新增用户
        userMapper.insert(userDO);
        //新增用户关联
        OrgUserDO orgUserDO = new OrgUserDO();
        orgUserDO.setOrgId(user.getOrg().getId());
        orgUserDO.setUserId(userDO.getId());
        orgUserMapper.insert(orgUserDO);
    }

    @Override
    public User findUser(String idNumber) {
        return UserConverter.INSTANCE.toEntity(userMapper.selectOne(new QueryWrapper<UserDO>().eq("id_number", idNumber)));
    }
}
