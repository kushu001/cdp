package com.chomolungma.system.post.infrastructure.converter;

import com.chomolungma.system.post.infrastructure.dataobject.PostDO;
import com.chomolungma.system.post.domain.entity.PostEntity;
import com.chomolungma.system.post.interfaces.dto.PostPageDTO;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostConverter {
    PostConverter INSTANCE = Mappers.getMapper(PostConverter.class);
    PostDO toDO(PostEntity postEntity);

    PostEntity toEntity(PostDO postDO);
    @Mappings({
            @Mapping(target = "records", source = "list"),
            @Mapping(target = "page", source = "pageNum")
    })
    PostPageDTO toDTO(PageInfo<PostDO> pageInfo);
}
