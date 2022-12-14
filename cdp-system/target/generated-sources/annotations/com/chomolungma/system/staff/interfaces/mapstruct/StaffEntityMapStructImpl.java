package com.chomolungma.system.staff.interfaces.mapstruct;

import com.chomolungma.system.staff.domain.entity.Org;
import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.interfaces.dto.PageStaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffFormDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffSearchDTO;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class StaffEntityMapStructImpl implements StaffEntityMapStruct {

    @Override
    public PageStaffDTO toPageUserDTO(PageInfo<StaffDTO> pageUsers) {
        if ( pageUsers == null ) {
            return null;
        }

        PageStaffDTO pageStaffDTO = new PageStaffDTO();

        List<StaffDTO> list = pageUsers.getList();
        if ( list != null ) {
            pageStaffDTO.setRecords( new ArrayList<StaffDTO>( list ) );
        }
        pageStaffDTO.setPage( pageUsers.getPageNum() );
        pageStaffDTO.setTotal( pageUsers.getTotal() );

        return pageStaffDTO;
    }

    @Override
    public Staff toEntity(StaffFormDTO staffFormDTO) {
        if ( staffFormDTO == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setId( staffFormDTO.getId() );
        staff.setName( staffFormDTO.getName() );
        staff.setGender( staffFormDTO.getGender() );
        staff.setIdNumber( staffFormDTO.getIdNumber() );
        staff.setTel( staffFormDTO.getTel() );
        staff.setPhone( staffFormDTO.getPhone() );
        staff.setAddress( staffFormDTO.getAddress() );
        staff.setCompany( staffFormDTO.getCompany() );

        return staff;
    }

    @Override
    public Staff toEntity(StaffSearchDTO staffSearchDTO) {
        if ( staffSearchDTO == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setId( staffSearchDTO.getId() );
        if ( staffSearchDTO.getCreateTime() != null ) {
            staff.setCreateTime( staffSearchDTO.getCreateTime().toInstant() );
        }
        if ( staffSearchDTO.getUpdateTime() != null ) {
            staff.setUpdateTime( staffSearchDTO.getUpdateTime().toInstant() );
        }
        staff.setCreateUser( staffSearchDTO.getCreateUser() );
        staff.setUpdateUser( staffSearchDTO.getUpdateUser() );
        staff.setStatus( staffSearchDTO.getStatus() );
        staff.setName( staffSearchDTO.getName() );
        staff.setGender( staffSearchDTO.getGender() );
        staff.setIdNumber( staffSearchDTO.getIdNumber() );
        staff.setTel( staffSearchDTO.getTel() );
        staff.setPhone( staffSearchDTO.getPhone() );
        staff.setAddress( staffSearchDTO.getAddress() );
        staff.setCompany( staffSearchDTO.getCompany() );

        return staff;
    }

    @Override
    public StaffDTO toDTO(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        StaffDTO staffDTO = new StaffDTO();

        staffDTO.setDeptId( staffOrgId( staff ) );
        staffDTO.setDeptName( staffOrgName( staff ) );
        staffDTO.setId( staff.getId() );
        if ( staff.getCreateTime() != null ) {
            staffDTO.setCreateTime( Date.from( staff.getCreateTime() ) );
        }
        if ( staff.getUpdateTime() != null ) {
            staffDTO.setUpdateTime( Date.from( staff.getUpdateTime() ) );
        }
        staffDTO.setCreateUser( staff.getCreateUser() );
        staffDTO.setUpdateUser( staff.getUpdateUser() );
        staffDTO.setStatus( staff.getStatus() );
        staffDTO.setName( staff.getName() );
        staffDTO.setGender( staff.getGender() );
        staffDTO.setIdNumber( staff.getIdNumber() );
        staffDTO.setTel( staff.getTel() );
        staffDTO.setPhone( staff.getPhone() );
        staffDTO.setAddress( staff.getAddress() );
        staffDTO.setCompany( staff.getCompany() );

        return staffDTO;
    }

    private Long staffOrgId(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Org org = staff.getOrg();
        if ( org == null ) {
            return null;
        }
        Long id = org.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String staffOrgName(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Org org = staff.getOrg();
        if ( org == null ) {
            return null;
        }
        String name = org.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
