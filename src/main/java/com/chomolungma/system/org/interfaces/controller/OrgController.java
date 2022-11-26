package com.chomolungma.system.org.interfaces.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.system.org.application.service.OrgService;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.domain.repository.IOrgRepository;
import com.chomolungma.system.org.interfaces.assembler.OrgAssembler;
import com.chomolungma.system.org.interfaces.dto.OrgDTO;
import com.chomolungma.system.org.interfaces.param.OrgParam;
import com.chomolungma.system.staff.application.service.StaffService;
import com.chomolungma.system.staff.interfaces.dto.StaffSearchDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/v1/org")
public class OrgController {

    private final OrgService orgService;

    private final StaffService staffService;

    private final IOrgRepository iOrgRepository;

    public OrgController(OrgService orgService, StaffService staffService, IOrgRepository iOrgRepository){
        this.orgService = orgService;
        this.staffService = staffService;
        this.iOrgRepository = iOrgRepository;
    }

    @GetMapping
    public Result queryOrg(OrgDTO orgDTO){
        List<OrgEntity> orgList = iOrgRepository.find(orgDTO);
        return Result.success(OrgAssembler.toDTO(orgList));
    }


    @GetMapping("/{id}")
    public Result getOrg(@PathVariable("id") Long id){
        return Result.success(iOrgRepository.findOne(id));
    }

    @PostMapping
    public Result createOrg(@RequestBody OrgParam orgParam){
        orgService.createOrg(orgParam);
        return Result.success();
    }

    @PutMapping
    public Result updateOrg(@RequestBody OrgParam orgParam){
        orgService.updateOrg(orgParam);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteOrg(@PathVariable("id") Long id){
        iOrgRepository.remove(id);
        return Result.success();
    }

    @GetMapping("/{code}/user")
    public Result getUsersByOrgId(@PathVariable("code") String code, StaffSearchDTO staffSearchDTO){
        return Result.success();
    }

    @DeleteMapping("/{code}/user/{ids}")
    public Result deleteUsers(@PathVariable("code") String code, @PathVariable("ids") String ids){
        staffService.deleteStaffs(code, Arrays.asList(ids.split(",")));
        return Result.success();
    }

}
