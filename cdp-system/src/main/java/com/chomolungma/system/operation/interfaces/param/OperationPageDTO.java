package com.chomolungma.system.operation.interfaces.param;

import com.chomolungma.core.dto.PageDTO;
import lombok.Data;

import java.util.List;

/**
*  Automatically generated code by CDP-GENERATOR maven-plugin.
*  Thank you for your use.
*  Good Luck!
*/

@Data
public class OperationPageDTO extends PageDTO {
    private List<OperationDTO> records;
}