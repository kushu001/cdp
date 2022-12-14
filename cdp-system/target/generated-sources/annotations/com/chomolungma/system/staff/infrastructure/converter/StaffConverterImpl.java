package com.chomolungma.system.staff.infrastructure.converter;

import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.infrastructure.dataobject.StaffDO;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import java.util.Date;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class StaffConverterImpl implements StaffConverter {

    @Override
    public StaffDO toDO(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        StaffDO staffDO = new StaffDO();

        staffDO.setId( staff.getId() );
        if ( staff.getCreateTime() != null ) {
            staffDO.setCreateTime( Date.from( staff.getCreateTime() ) );
        }
        if ( staff.getUpdateTime() != null ) {
            staffDO.setUpdateTime( Date.from( staff.getUpdateTime() ) );
        }
        staffDO.setCreateUser( staff.getCreateUser() );
        staffDO.setUpdateUser( staff.getUpdateUser() );
        staffDO.setStatus( staff.getStatus() );
        staffDO.setName( staff.getName() );
        if ( staff.getGender() != null ) {
            staffDO.setGender( String.valueOf( staff.getGender() ) );
        }
        staffDO.setTel( staff.getTel() );
        staffDO.setPhone( staff.getPhone() );
        staffDO.setIdNumber( staff.getIdNumber() );
        staffDO.setAddress( staff.getAddress() );
        staffDO.setCompany( staff.getCompany() );

        return staffDO;
    }

    @Override
    public Staff toEntity(StaffDO staffDO) {
        if ( staffDO == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setId( staffDO.getId() );
        if ( staffDO.getCreateTime() != null ) {
            staff.setCreateTime( staffDO.getCreateTime().toInstant() );
        }
        if ( staffDO.getUpdateTime() != null ) {
            staff.setUpdateTime( staffDO.getUpdateTime().toInstant() );
        }
        staff.setCreateUser( staffDO.getCreateUser() );
        staff.setUpdateUser( staffDO.getUpdateUser() );
        staff.setStatus( staffDO.getStatus() );
        staff.setName( staffDO.getName() );
        if ( staffDO.getGender() != null ) {
            staff.setGender( Integer.parseInt( staffDO.getGender() ) );
        }
        staff.setIdNumber( staffDO.getIdNumber() );
        staff.setTel( staffDO.getTel() );
        staff.setPhone( staffDO.getPhone() );
        staff.setAddress( staffDO.getAddress() );
        staff.setCompany( staffDO.getCompany() );

        return staff;
    }

    @Override
    public StaffDTO toDTO(StaffDO staffDO) {
        if ( staffDO == null ) {
            return null;
        }

        StaffDTO staffDTO = new StaffDTO();

        staffDTO.setId( staffDO.getId() );
        staffDTO.setCreateTime( staffDO.getCreateTime() );
        staffDTO.setUpdateTime( staffDO.getUpdateTime() );
        staffDTO.setCreateUser( staffDO.getCreateUser() );
        staffDTO.setUpdateUser( staffDO.getUpdateUser() );
        staffDTO.setStatus( staffDO.getStatus() );
        staffDTO.setName( staffDO.getName() );
        if ( staffDO.getGender() != null ) {
            staffDTO.setGender( Integer.parseInt( staffDO.getGender() ) );
        }
        staffDTO.setIdNumber( staffDO.getIdNumber() );
        staffDTO.setTel( staffDO.getTel() );
        staffDTO.setPhone( staffDO.getPhone() );
        staffDTO.setAddress( staffDO.getAddress() );
        staffDTO.setCompany( staffDO.getCompany() );

        return staffDTO;
    }
}
