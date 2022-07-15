package com.chomolungma.system.user.interfaces.dto;

import com.chomolungma.core.interfaces.dto.BaseDTO;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {
    private String name;
    private Integer gender;
    private String tel;
    private String address;
    private String company;
}