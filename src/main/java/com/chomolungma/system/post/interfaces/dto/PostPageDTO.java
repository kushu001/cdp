package com.chomolungma.system.post.interfaces.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class PostPageDTO extends PageDTO {
    List<PostDTO> records;
}
