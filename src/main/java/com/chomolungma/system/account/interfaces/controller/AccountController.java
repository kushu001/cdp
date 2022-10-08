package com.chomolungma.system.account.interfaces.controller;

import com.alibaba.excel.EasyExcel;
import com.chomolungma.common.result.Result;
import com.chomolungma.core.application.service.ExcelService;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.account.application.service.AccountService;
import com.chomolungma.system.account.domain.assembler.AccountAssembler;
import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.domain.repository.IAccountRepository;
import com.chomolungma.system.account.infrastructure.listener.AccountExcelListener;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.account.interfaces.dto.AccountExcelDTO;
import com.chomolungma.system.account.interfaces.dto.AccountInDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService accountService;
    private final IAccountRepository iAccountRepository;
    private final ExcelService excelService;

    public AccountController(AccountService accountService, IAccountRepository iAccountRepository, ExcelService excelService) {
        this.accountService = accountService;
        this.iAccountRepository = iAccountRepository;
        this.excelService = excelService;
    }

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
    public Result getPageList(PageDTO pageDTO,
                              @RequestParam(required = false) String username,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String nickname,
                              @RequestParam(required = false) Integer status){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername(username);
        accountDTO.setName(name);
        accountDTO.setNickname(nickname);
        accountDTO.setStatus(status);
        return Result.success(iAccountRepository.queryPageList(AccountAssembler.toEntity(accountDTO),pageDTO.getPage(), pageDTO.getLimit()));
    }

    @GetMapping("/{id}")
    public Result getAccount(@PathVariable("id") Long id){
        return Result.success(iAccountRepository.queryAccount(id));
    }

    @PostMapping
    public Result createAccount(@RequestBody AccountInDTO accountInDTO){
        Account account = AccountAssembler.toEntity(accountInDTO);
        accountService.createAccount(account);
        return Result.success();
    }

    @PutMapping
    public Result updateAccount(@RequestBody AccountInDTO accountInDTO){
        Account account = AccountAssembler.toEntity(accountInDTO);
        accountService.updateAccount(account);
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
        List<Account> accountEntities = accountService.getAccounts(AccountAssembler.toEntity(accountDTO));
        excelService.export(AccountAssembler.toExcelDTO(accountEntities), AccountExcelDTO.class);
    }
}
