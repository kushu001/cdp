package com.chomolungma.system.staff.interfaces.controller;

import com.chomolungma.core.dto.PageDTO;
import com.chomolungma.core.result.Result;
import com.chomolungma.core.service.ExcelService;
import com.chomolungma.system.staff.application.service.StaffService;
import com.chomolungma.system.staff.interfaces.assembler.StaffAssembler;
import com.chomolungma.system.staff.interfaces.dto.StaffExcelDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffFormDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class StaffController {

    private final StaffService staffService;
    private final ExcelService excelService;

    public StaffController(StaffService staffService, ExcelService excelService) {
        this.staffService = staffService;
        this.excelService = excelService;
    }

    @GetMapping
    public Result pageList(PageDTO pageDTO,
                           @RequestParam(required = false) Long orgId,
                           @RequestParam(required = false) String name,
                           @RequestParam(value = "id_number", required = false) String idNumber,
                           @RequestParam(required = false) String phone,
                           @RequestParam(required = false) String tel,
                           @RequestParam(required = false) String address){
        return Result.success(staffService.getStaffs(null, name, idNumber, phone, tel, address, 1, pageDTO.getPage(), pageDTO.getLimit()));
    }

    @GetMapping("/org/{orgId}")
    public Result pageList(@PathVariable("orgId") Long orgId, PageDTO pageDTO,
                           @RequestParam(required = false) String name,
                           @RequestParam(value = "id_number", required = false) String idNumber,
                           @RequestParam(required = false) String phone,
                           @RequestParam(required = false) String tel,
                           @RequestParam(required = false) String address
    ){
        return Result.success(staffService.getStaffs(orgId, name, idNumber, phone, tel, address, null, pageDTO.getPage(), pageDTO.getLimit()));
    }

    @GetMapping("/{id}")
    public Result info(@PathVariable("id") Long id){
        return Result.success(staffService.getStaff(id));
    }

    @PostMapping("/org/{orgId}")
    public Result createUser(@PathVariable("orgId") Long orgId, @RequestBody StaffFormDTO staffFormDTO){
        staffService.createStaff(orgId, staffFormDTO);
        return Result.success();
    }

    @PutMapping
    public Result updateUser(@RequestBody StaffFormDTO staffFormDTO){
        staffService.updateStaff(staffFormDTO);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteUser(@PathVariable("ids") String ids){
        staffService.deleteStaffs(Arrays.asList(ids.split(",")));
        return Result.success();
    }

    @PutMapping("/audit/{id}")
    public Result audit(@PathVariable("id") Long id){
        staffService.audit(id);
        return Result.success();
    }

    @PostMapping("/org/{code}/import")
    public void importExcel(@PathVariable("code") String code, MultipartFile file){
        System.out.println(file.getOriginalFilename());
    }

    @GetMapping("/org/{orgId}/export")
    public void exportExcel(@PathVariable("orgId") Long orgId,
                            @RequestParam(required = false) String name,
                            @RequestParam(value = "id_number", required = false) String idNumber,
                            @RequestParam(required = false) String phone,
                            @RequestParam(required = false) String tel,
                            @RequestParam(required = false) String address) throws IOException {
        excelService.export(staffService.getStaffs(orgId, name, idNumber, phone, tel, address), StaffExcelDTO.class);
    }

}
