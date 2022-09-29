package com.chomolungma.system.post.interfaces.mapstruct;

import com.chomolungma.system.post.domain.entity.PostEntity;
import com.chomolungma.system.post.interfaces.param.PostParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostEntityMapStruct {
    PostEntityMapStruct INSTANCE = Mappers.getMapper(PostEntityMapStruct.class);
    PostEntity toEntity(PostParam param);

}
