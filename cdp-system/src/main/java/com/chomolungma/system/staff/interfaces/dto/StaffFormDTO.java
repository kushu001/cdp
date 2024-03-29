package com.chomolungma.system.staff.interfaces.dto;

import lombok.Data;

import java.util.List;

@Data
public class StaffFormDTO {
    private Long id;
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
    private List<Long> postIds;
    private List<Long> orgIds;
}
