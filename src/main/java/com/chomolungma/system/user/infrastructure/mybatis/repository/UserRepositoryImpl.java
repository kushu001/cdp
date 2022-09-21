package com.chomolungma.system.user.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.org.infrastructure.mybatis.repository.mapper.OrgMapper;
import com.chomolungma.system.user.domain.entity.Org;
import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.domain.entity.UserEntity;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrgUserMapper orgUserMapper;
    @Autowired
    private OrgMapper orgMapper;

    @Autowired
    private OrgAdapter orgAdapter;


    @Override
    public PageUserDTO getUsersByCode(String code, User user, int current, int size) {
        PageHelper.startPage(current, size);
        List<UserDTO> userOrgDOS = userMapper.selectUsersByCondition(code, UserConverter.INSTANCE.toDO(user));
        PageInfo<UserDTO> pageInfo = new PageInfo<>(userOrgDOS);
        //PageHelper.clearPage();
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
    public UserDTO findUser(Long id) {
        UserDO userDO = userMapper.selectById(id);
        OrgUserDO orgUserDO = orgUserMapper.selectOne(new QueryWrapper<OrgUserDO>().eq("user_id", userDO.getId()));
        Org org = orgAdapter.adapter(orgUserDO.getOrgId());
        UserDTO userDTO = UserConverter.INSTANCE.toDTO(userDO);
        userDTO.setDeptId(org.getId());
        userDTO.setDeptName(org.getName());
        return userDTO;
    }
}
