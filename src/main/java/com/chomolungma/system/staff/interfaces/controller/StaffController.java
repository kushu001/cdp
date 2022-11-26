package com.chomolungma.system.staff.interfaces.controller;


import com.chomolungma.common.result.Result;
import com.chomolungma.core.application.service.ExcelService;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.staff.application.service.StaffService;
import com.chomolungma.system.staff.interfaces.assembler.StaffAssembler;
import com.chomolungma.system.staff.interfaces.dto.StaffExcelDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffFormDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffSearchDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
                           @RequestParam(required = false) String name,
                           @RequestParam(value = "id_number", required = false) String idNumber,
                           @RequestParam(required = false) String phone,
                           @RequestParam(required = false) String tel,
                           @RequestParam(required = false) String address){
        return Result.success(staffService.getStaffs(null, name, idNumber, phone, tel, address, pageDTO.getPage(), pageDTO.getLimit()));
    }

    @GetMapping("/org/{code}")
    public Result pageList(@PathVariable("code") String code, PageDTO pageDTO,
                           @RequestParam(required = false) String name,
                           @RequestParam(value = "id_number", required = false) String idNumber,
                           @RequestParam(required = false) String phone,
                           @RequestParam(required = false) String tel,
                           @RequestParam(required = false) String address
    ){
        return Result.success(staffService.getStaffs(code, name, idNumber, phone, tel, address, pageDTO.getPage(), pageDTO.getLimit()));
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
        staffService.updateStaff(StaffAssembler.toEntity(staffFormDTO));
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

    @GetMapping("/org/{code}/export")
    public void exportExcel(@PathVariable("code") String code,
                            @RequestParam(required = false) String name,
                            @RequestParam(value = "id_number", required = false) String idNumber,
                            @RequestParam(required = false) String phone,
                            @RequestParam(required = false) String tel,
                            @RequestParam(required = false) String address) throws IOException {
        StaffSearchDTO staffSearchDTO = new StaffSearchDTO();
        staffSearchDTO.setIdNumber(idNumber);
        staffSearchDTO.setName(name);
        staffSearchDTO.setPhone(phone);
        staffSearchDTO.setTel(tel);
        staffSearchDTO.setAddress(address);
        excelService.export(staffService.getStaffs(code, name, idNumber, phone, tel, address), StaffExcelDTO.class);
    }

}
