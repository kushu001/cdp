package com.chomolungma.system.user.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.system.user.domain.entity.Org;
import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.domain.repository.IUserRepository;
import com.chomolungma.system.user.infrastructure.adapter.OrgAdapter;
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
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private final UserMapper userMapper;
    private final OrgUserMapper orgUserMapper;
    private final OrgAdapter orgAdapter;

    public UserRepositoryImpl(UserMapper userMapper, OrgUserMapper orgUserMapper, OrgAdapter orgAdapter) {
        this.userMapper = userMapper;
        this.orgUserMapper = orgUserMapper;
        this.orgAdapter = orgAdapter;
    }


    @Override
    public List<UserDTO> getUsers(String code, User user) {
        return userMapper.selectUsersByCondition(code, UserConverter.INSTANCE.toDO(user));
    }

    @Override
    public void save(User user) {
        // 转换成DO
        UserDO userDO = UserConverter.INSTANCE.toDO(user);

        if (userDO.getId() == null){
            // 新增用户
            userMapper.insert(userDO);
            //新增用户关联
            OrgUserDO orgUserDO = new OrgUserDO();
            orgUserDO.setOrgId(user.getOrg().getId());
            orgUserDO.setUserId(userDO.getId());
            orgUserMapper.insert(orgUserDO);
        }else{
            userMapper.updateById(userDO);
        }

    }

    @Override
    public void remove(List<Long> ids) {
        Boolean count = userMapper.noDeleteCount(ids);
        if (count){
            if (ids.size()>1){
                throw new BusinessRuntimeException("含有[通过]状态的人员数据，无法删除！");
            }else{
                throw new BusinessRuntimeException("当前人员数据状态为[通过]，无法删除！");
            }

        }
        // 删除用户信息
        userMapper.deleteBatchIds(ids);
        // 删除用户部门关联信息
        orgUserMapper.delete(new QueryWrapper<OrgUserDO>().in("user_id", ids));
    }

    @Override
    public User findUser(String idNumber) {
        return UserConverter.INSTANCE.toEntity(userMapper.selectOne(new QueryWrapper<UserDO>().eq("id_number", idNumber)));
    }

    @Override
    public User findUser(Long id) {
        UserDO userDO = userMapper.selectById(id);
        OrgUserDO orgUserDO = orgUserMapper.selectOne(new QueryWrapper<OrgUserDO>().eq("user_id", userDO.getId()));
        Org org = orgAdapter.adapter(orgUserDO.getOrgId());
        User user = UserConverter.INSTANCE.toEntity(userDO);
        user.setOrg(org);
        return user;
    }
}
