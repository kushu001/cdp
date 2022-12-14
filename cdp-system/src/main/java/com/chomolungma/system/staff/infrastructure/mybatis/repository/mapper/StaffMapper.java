package com.chomolungma.system.staff.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.staff.infrastructure.dataobject.StaffDO;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface StaffMapper extends BaseMapper<StaffDO> {
    List<StaffDTO> selectStaffsByCondition(@Param("code") String code, @Param("staffDO") StaffDO staffDO);

    Boolean noDeleteCount(List<Long> ids);
}
