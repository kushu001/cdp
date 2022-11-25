package com.chomolungma.system.user.interfaces.controller;


import com.chomolungma.common.result.Result;
import com.chomolungma.core.CurrentProfileHolder;
import com.chomolungma.core.application.service.ExcelService;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.user.application.service.UserService;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.UserExcelDTO;
import com.chomolungma.system.user.interfaces.dto.UserFormDTO;
import com.chomolungma.system.user.interfaces.dto.UserSearchDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final ExcelService excelService;

    public UserController(UserService userService, ExcelService excelService) {
        this.userService = userService;
        this.excelService = excelService;
    }

    @GetMapping
    public Result pageList(PageDTO pageDTO,
                           @RequestParam(required = false) String name,
                           @RequestParam(value = "id_number", required = false) String idNumber,
                           @RequestParam(required = false) String phone,
                           @RequestParam(required = false) String tel,
                           @RequestParam(required = false) String address){
        return Result.success(userService.getUsers(null, name, idNumber, phone, tel, address, pageDTO.getPage(), pageDTO.getLimit()));
    }

    @GetMapping("/org/{code}")
    public Result pageList(@PathVariable("code") String code, PageDTO pageDTO,
                           @RequestParam(required = false) String name,
                           @RequestParam(value = "id_number", required = false) String idNumber,
                           @RequestParam(required = false) String phone,
                           @RequestParam(required = false) String tel,
                           @RequestParam(required = false) String address
    ){
        return Result.success(userService.getUsers(code, name, idNumber, phone, tel, address, pageDTO.getPage(), pageDTO.getLimit()));
    }

    @GetMapping("/{id}")
    public Result info(@PathVariable("id") Long id){
        return Result.success(userService.getUser(id));
    }

    @PostMapping("/org/{orgId}")
    public Result createUser(@PathVariable("orgId") Long orgId, @RequestBody UserFormDTO userFormDTO){
        userService.createUser(orgId, userFormDTO);
        return Result.success();
    }

    @PutMapping
    public Result updateUser(@RequestBody UserFormDTO userFormDTO){
        userService.updateUser(UserAssembler.toEntity(userFormDTO));
        return Result.success();
    }

    @GetMapping("/menu")
    public Result getMenus(){
        List<Long> roleIds = CurrentProfileHolder.getProfile().getRoleIds();
        return Result.success(userService.getMenus(roleIds));
    }

    @PutMapping("/audit/{id}")
    public Result audit(@PathVariable("id") Long id){
        userService.audit(id);
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
        UserSearchDTO userSearchDTO = new UserSearchDTO();
        userSearchDTO.setIdNumber(idNumber);
        userSearchDTO.setName(name);
        userSearchDTO.setPhone(phone);
        userSearchDTO.setTel(tel);
        userSearchDTO.setAddress(address);
        excelService.export(userService.getUsers(code, name, idNumber, phone, tel, address), UserExcelDTO.class);
    }

}
