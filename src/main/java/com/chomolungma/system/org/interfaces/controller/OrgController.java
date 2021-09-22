package com.chomolungma.system.org.interfaces.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.common.result.Result;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.mapper.OrgMapper;
import com.chomolungma.system.org.interfaces.assembler.OrgAssembler;
import com.chomolungma.system.org.interfaces.param.OrgParam;
import com.chomolungma.system.org.interfaces.param.OrgSearchParam;
import com.chomolungma.system.org.application.service.OrgService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/org")
public class OrgController {

    private OrgService orgService;

    private OrgMapper orgMapper;

    public OrgController(OrgService orgService, OrgMapper orgMapper){
        this.orgService = orgService;
        this.orgMapper = orgMapper;
    }

    @GetMapping
    public Result queryOrg(OrgSearchParam orgSearchParam){

        OrgEntity orgEntity = new OrgEntity();

        orgEntity.setName(orgSearchParam.getName());

        orgEntity.setTel(orgSearchParam.getTel());

        orgEntity.setManager(orgSearchParam.getManager());

        orgEntity.setManagerId(orgSearchParam.getManagerId());

        orgEntity.setStatus(orgSearchParam.getStatus());

        List<OrgEntity> orgEntityList = orgService.query(orgEntity);

        return Result.success(OrgAssembler.convertToDto(orgEntityList));

    }

    @GetMapping("/all")
    public Result queryAll(){
        return Result.success(orgMapper.selectList(new QueryWrapper<>()));
    }


    @PostMapping
    public Result createOrg(@RequestBody OrgParam orgParam){
        orgService.createOrg(OrgAssembler.convertParamToEntity(orgParam));
        return Result.success();
    }

    @PutMapping
    public Result updateOrg(@RequestBody OrgParam orgParam){
        orgService.updateOrg(OrgAssembler.convertParamToEntity(orgParam));
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteOrg(@PathVariable("ids") String ids){
        orgService.deleteOrg(ids);
        return Result.success();
    }
}
