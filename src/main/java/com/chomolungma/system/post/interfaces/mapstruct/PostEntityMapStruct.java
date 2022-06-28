package com.chomolungma.system.post.interfaces.mapstruct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.post.interfaces.dto.PostPageDTO;
import com.chomolungma.system.post.domain.entity.PostEntity;
import com.chomolungma.system.post.interfaces.param.PostPageParam;
import com.chomolungma.system.post.interfaces.param.PostParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostEntityMapStruct {
    PostEntityMapStruct INSTANCE = Mappers.getMapper(PostEntityMapStruct.class);

    PostPageDTO toDTO(IPage<PostEntity> postEntityIPage);

    PostEntity toEntity(PostPageParam param);

    PostEntity toEntity(PostParam param);
}
