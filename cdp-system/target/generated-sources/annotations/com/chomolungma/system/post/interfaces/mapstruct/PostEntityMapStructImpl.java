package com.chomolungma.system.post.interfaces.mapstruct;

import com.chomolungma.system.post.domain.entity.PostEntity;
import com.chomolungma.system.post.interfaces.dto.PostDTO;
import com.chomolungma.system.post.interfaces.param.PostParam;
import java.util.Date;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class PostEntityMapStructImpl implements PostEntityMapStruct {

    @Override
    public PostEntity toEntity(PostParam param) {
        if ( param == null ) {
            return null;
        }

        PostEntity postEntity = new PostEntity();

        postEntity.setId( param.getId() );
        postEntity.setName( param.getName() );
        postEntity.setCode( param.getCode() );
        postEntity.setType( param.getType() );
        postEntity.setSort( param.getSort() );

        return postEntity;
    }

    @Override
    public PostDTO toDTO(PostEntity postEntity) {
        if ( postEntity == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setId( postEntity.getId() );
        if ( postEntity.getCreateTime() != null ) {
            postDTO.setCreateTime( Date.from( postEntity.getCreateTime() ) );
        }
        if ( postEntity.getUpdateTime() != null ) {
            postDTO.setUpdateTime( Date.from( postEntity.getUpdateTime() ) );
        }
        postDTO.setCreateUser( postEntity.getCreateUser() );
        postDTO.setUpdateUser( postEntity.getUpdateUser() );
        postDTO.setStatus( postEntity.getStatus() );
        postDTO.setName( postEntity.getName() );
        postDTO.setCode( postEntity.getCode() );
        postDTO.setType( postEntity.getType() );
        postDTO.setTypeName( postEntity.getTypeName() );
        postDTO.setSort( postEntity.getSort() );

        return postDTO;
    }
}
