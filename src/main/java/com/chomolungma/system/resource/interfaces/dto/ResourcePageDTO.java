package com.chomolungma.system.resource.interfaces.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class ResourcePageDTO extends PageDTO {
    List<ResourceDTO> records;
}
