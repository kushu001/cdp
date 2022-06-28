package com.chomolungma.system.account.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.system.account.assembler.AccountAssembler;
import com.chomolungma.system.account.dto.AccountDTO;
import com.chomolungma.system.account.dto.AccountInDTO;
import com.chomolungma.system.account.entity.AccountEntity;
import com.chomolungma.system.account.repository.IAccountRepository;
import com.chomolungma.system.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private IAccountRepository iAccountRepository;

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
        return Result.success(iAccountRepository.queryAccount(id));
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
}
