package com.chomolungma.system.user.interfaces.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class PageUserDTO extends PageDTO {
    private List<UserDTO> records;
}
