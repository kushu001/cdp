package com.chomolungma.system.user.domain.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer gender;
    private String idNumber;
    private String tel;
    private String phone;
    private String address;
    private String company;
    private Org org;
    private Integer status;

}
