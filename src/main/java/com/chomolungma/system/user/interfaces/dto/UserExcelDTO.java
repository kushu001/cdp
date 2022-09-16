package com.chomolungma.system.user.interfaces.dto;

import lombok.Data;

@Data
public class UserExcelDTO {
    private String name;
    private Integer gender;
    private String idNumber;
    private String tel;
    private String phone;
    private String address;
    private String company;
    private String deptId;
    private String deptName;
}
