package com.chomolungma.system.user.interfaces.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

@Data
public class UserSearchDTO extends PageDTO {
    private String name;
    private Integer gender;
    private String idNumber;
    private String tel;
    private String address;
    private String company;
}
