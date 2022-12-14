package com.chomolungma.system.post.infrastructure.converter;

import com.chomolungma.system.post.domain.entity.PostEntity;
import com.chomolungma.system.post.infrastructure.dataobject.PostDO;
import com.chomolungma.system.post.interfaces.dto.PostDTO;
import com.chomolungma.system.post.interfaces.dto.PostPageDTO;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class PostConverterImpl implements PostConverter {

    @Override
    public PostDO toDO(PostEntity postEntity) {
        if ( postEntity == null ) {
            return null;
        }

        PostDO postDO = new PostDO();

        postDO.setId( postEntity.getId() );
        if ( postEntity.getCreateTime() != null ) {
            postDO.setCreateTime( Date.from( postEntity.getCreateTime() ) );
        }
        if ( postEntity.getUpdateTime() != null ) {
            postDO.setUpdateTime( Date.from( postEntity.getUpdateTime() ) );
        }
        postDO.setCreateUser( postEntity.getCreateUser() );
        postDO.setUpdateUser( postEntity.getUpdateUser() );
        postDO.setStatus( postEntity.getStatus() );
        postDO.setName( postEntity.getName() );
        postDO.setCode( postEntity.getCode() );
        postDO.setType( postEntity.getType() );
        postDO.setSort( postEntity.getSort() );

        return postDO;
    }

    @Override
    public PostEntity toEntity(PostDO postDO) {
        if ( postDO == null ) {
            return null;
        }

        PostEntity postEntity = new PostEntity();

        postEntity.setId( postDO.getId() );
        if ( postDO.getCreateTime() != null ) {
            postEntity.setCreateTime( postDO.getCreateTime().toInstant() );
        }
        if ( postDO.getUpdateTime() != null ) {
            postEntity.setUpdateTime( postDO.getUpdateTime().toInstant() );
        }
        postEntity.setCreateUser( postDO.getCreateUser() );
        postEntity.setUpdateUser( postDO.getUpdateUser() );
        postEntity.setStatus( postDO.getStatus() );
        postEntity.setName( postDO.getName() );
        postEntity.setCode( postDO.getCode() );
        postEntity.setType( postDO.getType() );
        postEntity.setSort( postDO.getSort() );

        return postEntity;
    }

    @Override
    public PostPageDTO toDTO(PageInfo<PostDO> pageInfo) {
        if ( pageInfo == null ) {
            return null;
        }

        PostPageDTO postPageDTO = new PostPageDTO();

        postPageDTO.setRecords( postDOListToPostDTOList( pageInfo.getList() ) );
        postPageDTO.setPage( pageInfo.getPageNum() );
        postPageDTO.setTotal( pageInfo.getTotal() );

        return postPageDTO;
    }

    protected PostDTO postDOToPostDTO(PostDO postDO) {
        if ( postDO == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setId( postDO.getId() );
        postDTO.setCreateTime( postDO.getCreateTime() );
        postDTO.setUpdateTime( postDO.getUpdateTime() );
        postDTO.setCreateUser( postDO.getCreateUser() );
        postDTO.setUpdateUser( postDO.getUpdateUser() );
        postDTO.setStatus( postDO.getStatus() );
        postDTO.setName( postDO.getName() );
        postDTO.setCode( postDO.getCode() );
        postDTO.setType( postDO.getType() );
        postDTO.setSort( postDO.getSort() );

        return postDTO;
    }

    protected List<PostDTO> postDOListToPostDTOList(List<PostDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PostDTO> list1 = new ArrayList<PostDTO>( list.size() );
        for ( PostDO postDO : list ) {
            list1.add( postDOToPostDTO( postDO ) );
        }

        return list1;
    }
}
