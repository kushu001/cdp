package com.chomolungma.system.staff.interfaces.dto;

import com.chomolungma.core.dto.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class StaffDTO extends BaseDTO {
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
    private List<Long> orgIds;
    private String orgNames;
    private List<Long> postIds;
    private String postNames;
}
