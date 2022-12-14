package com.chomolungma.system.staff.domain.entity;

import com.chomolungma.core.entity.BaseEntity;
import lombok.Data;

@Data
public class Staff extends BaseEntity {
    private String name;
    private Integer gender;
    private String idNumber;
    private String tel;
    private String phone;
    private String address;
    private String company;
    private Org org;


    public void audit(){
        this.setStatus(1);
    }

}
