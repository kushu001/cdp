package com.chomolungma.system.account.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.core.application.service.ExcelService;
import com.chomolungma.system.account.assembler.AccountAssembler;
import com.chomolungma.system.account.dto.AccountDTO;
import com.chomolungma.system.account.dto.AccountExcelDTO;
import com.chomolungma.system.account.dto.AccountInDTO;
import com.chomolungma.system.account.entity.AccountEntity;
import com.chomolungma.system.account.listener.AccountExcelListener;
import com.chomolungma.system.account.repository.IAccountRepository;
import com.chomolungma.system.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private IAccountRepository iAccountRepository;

    @Autowired
    private ExcelService excelService;
    @Autowired
    private HttpServletResponse response;

    @GetMapping("/get")
    public Map<String, Object> getProfile(){
        Map<String, Object> map = new HashMap<>();
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        map.put("roles", roles);
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");
        map.put("code",200);
        return map;
    }

    @GetMapping
    public Result getPageList(AccountDTO accountDTO){
        return Result.success(accountService.getAccounts(new Page<>(accountDTO.getPage(), accountDTO.getLimit()), AccountAssembler.toEntity(accountDTO)));
    }

    @GetMapping("/{id}")
    public Result getAccount(@PathVariable("id") Long id){
        return Result.success(AccountAssembler.toDTO(iAccountRepository.queryAccount(id)));
    }

    @PostMapping
    public Result createAccount(@RequestBody AccountInDTO accountInDTO){
        AccountEntity accountEntity = AccountAssembler.toEntity(accountInDTO);
        accountService.createAccount(accountEntity);
        return Result.success();
    }

    @PutMapping
    public Result updateAccount(@RequestBody AccountInDTO accountInDTO){
        AccountEntity accountEntity = AccountAssembler.toEntity(accountInDTO);
        accountService.updateAccount(accountEntity);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteAccount(@PathVariable("ids") String ids){
        iAccountRepository.remove(Arrays.asList(ids.split(",")));
        return Result.success();
    }

    @PutMapping("/password/{id}")
    public Result resetPassword(@PathVariable("id") Long id){
        accountService.resetPassword(id);
        return Result.success();
    }

    @PutMapping("/{id}/user/{userId}")
    public Result bindUser(@PathVariable("id") Long id, @PathVariable("userId") Long userId){
        accountService.bindUser(id, userId);
        return Result.success();
    }


    @PostMapping("/import")
    @Transactional
    public void importExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), AccountExcelDTO.class, new AccountExcelListener(iAccountRepository, excelService)).sheet().doRead();
    }

    @GetMapping("/export")
    public void export(AccountDTO accountDTO) throws IOException {
        List<AccountEntity> accountEntities = accountService.getAccounts(AccountAssembler.toEntity(accountDTO));
        excelService.export(AccountAssembler.toExcelDTO(accountEntities), AccountExcelDTO.class);
    }
}
