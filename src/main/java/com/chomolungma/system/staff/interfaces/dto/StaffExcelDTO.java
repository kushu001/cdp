package com.chomolungma.system.staff.interfaces.dto;

import lombok.Data;

@Data
public class StaffExcelDTO {
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
