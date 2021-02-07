package com.chomolungma.cdp.tree;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrgEntityMapStruct {

    List<OrgTree> orgToOrgTree(List<Org> org);






}
