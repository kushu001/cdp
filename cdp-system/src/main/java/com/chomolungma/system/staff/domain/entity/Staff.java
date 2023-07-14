package com.chomolungma.system.staff.domain.entity;

import com.chomolungma.core.entity.BaseEntity;
import lombok.Data;

@Data
public class Staff extends BaseEntity {
    private String code;
    private String name;
    private Integer gender;
    private String idNumber;
    private String tel;
    private String phone;
    private String email;
    private String address;
    private String homeAddress;
    private String company;
    private Org org;


    public void audit(){
        this.setStatus(1);
    }

}
