package com.chomolungma.system.role.domain.service;

import com.chomolungma.system.menu.interfaces.assembler.MenuAssembler;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.role.domain.repository.IRoleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMenuDomainService {
    private final IRoleRepository iRoleRepository;

    public GetMenuDomainService(IRoleRepository iRoleRepository) {
        this.iRoleRepository = iRoleRepository;
    }

    public List<MenuDTO> getMenusByRoleIds(List<Long> roleIds){
        return MenuAssembler.convertToDto(iRoleRepository.query(roleIds));
    }
}
