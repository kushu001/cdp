package com.chomolungma.system.user.interfaces.dto;

import com.chomolungma.core.interfaces.dto.BaseDTO;
import lombok.Data;

@Data
public class User extends BaseDTO {
    private String name;
    private Integer gender;
    private String tel;
    private String phone;
    private String address;
    private String company;
}
