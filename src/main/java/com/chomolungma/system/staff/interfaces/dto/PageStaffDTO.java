package com.chomolungma.system.staff.interfaces.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class PageStaffDTO extends PageDTO {
    private List<StaffDTO> records;
}
