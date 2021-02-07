package com.chomolungma.org.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.common.result.Result;
import com.chomolungma.org.assembler.OrgAssembler;
import com.chomolungma.org.mapper.OrgMapper;
import com.chomolungma.org.param.OrgParam;
import com.chomolungma.org.param.OrgSearchParam;
import com.chomolungma.org.pojo.Org;
import com.chomolungma.org.service.OrgService;
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

        Org org = new Org();

        org.setName(orgSearchParam.getName());

        org.setTel(orgSearchParam.getTel());

        org.setManager(orgSearchParam.getManager());

        org.setManagerId(orgSearchParam.getManagerId());

        org.setStatus(orgSearchParam.getStatus());

        List<Org> orgList = orgService.query(org);

        return Result.success(OrgAssembler.convertToDto(orgList));

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
        return Result.success();
    }
}
