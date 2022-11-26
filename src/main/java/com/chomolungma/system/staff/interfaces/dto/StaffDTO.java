package com.chomolungma.system.staff.interfaces.dto;

import com.chomolungma.core.interfaces.dto.BaseDTO;
import lombok.Data;

@Data
public class StaffDTO extends BaseDTO {
    private String name;
    private Integer gender;
    private String idNumber;
    private String tel;
    private String phone;
    private String address;
    private String company;
    private Long deptId;
    private String deptName;
}
