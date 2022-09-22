package com.chomolungma.system.user.interfaces.controller;


import com.chomolungma.common.result.Result;
import com.chomolungma.core.CurrentProfileHolder;
import com.chomolungma.core.application.service.ExcelService;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.user.application.service.UserService;
import com.chomolungma.system.user.infrastructure.mybatis.repository.mapper.UserMapper;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.UserExcelDTO;
import com.chomolungma.system.user.interfaces.dto.UserFormDTO;
import com.chomolungma.system.user.interfaces.dto.UserSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ExcelService excelService;

    @GetMapping
    public Result pageList(PageDTO pageDTO,
                           @RequestParam(required = false) String name,
                           @RequestParam(value = "id_number", required = false) String idNumber,
                           @RequestParam(required = false) String phone,
                           @RequestParam(required = false) String tel,
                           @RequestParam(required = false) String address){
        UserSearchDTO userSearchDTO = new UserSearchDTO();
        userSearchDTO.setIdNumber(idNumber);
        userSearchDTO.setName(name);
        userSearchDTO.setPhone(phone);
        userSearchDTO.setTel(tel);
        userSearchDTO.setAddress(address);
        userSearchDTO.setPage(pageDTO.getPage());
        userSearchDTO.setLimit(pageDTO.getLimit());
        return Result.success(userService.getUsers(userSearchDTO));
    }

    @GetMapping("/org/{code}")
    public Result pageList(@PathVariable("code") String code, PageDTO pageDTO,
                           @RequestParam(required = false) String name,
                           @RequestParam(value = "id_number", required = false) String idNumber,
                           @RequestParam(required = false) String phone,
                           @RequestParam(required = false) String tel,
                           @RequestParam(required = false) String address
    ){
        UserSearchDTO userSearchDTO = new UserSearchDTO();
        userSearchDTO.setIdNumber(idNumber);
        userSearchDTO.setName(name);
        userSearchDTO.setPhone(phone);
        userSearchDTO.setTel(tel);
        userSearchDTO.setAddress(address);
        userSearchDTO.setPage(pageDTO.getPage());
        userSearchDTO.setLimit(pageDTO.getLimit());
        return Result.success(userService.getUsersByOrg(code, userSearchDTO));
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

    @PostMapping("/org/{code}/import")
    public void importExcel(@PathVariable("code") String code, MultipartFile file){
        System.out.println(file.getOriginalFilename());
    }

    @GetMapping("/org/{code}/export")
    public void exportExcel(@PathVariable("code") String code,UserSearchDTO userSearchDTO) throws IOException {
        excelService.export(userService.getUsers(code, UserAssembler.toUserEntity(userSearchDTO)), UserExcelDTO.class);
    }

}
