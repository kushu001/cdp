package com.chomolungma.cdp.mapstruct;

import com.chomolungma.cdp.mapstruct.source.PageSon;
import com.chomolungma.cdp.mapstruct.target.PageSub;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestMapper {
    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

    @Mappings({
            @Mapping(target = "records", source = "list")
    }
    )
    PageSub toPageSub(PageSon pageSon);
}
