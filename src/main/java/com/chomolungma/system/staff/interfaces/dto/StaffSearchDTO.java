package com.chomolungma.system.staff.interfaces.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

@Data
public class StaffSearchDTO extends PageDTO {
    private String name;
    private Integer gender;
    private String idNumber;
    private String tel;
    private String phone;
    private String address;
    private String company;
}
