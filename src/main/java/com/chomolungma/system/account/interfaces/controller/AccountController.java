package com.chomolungma.system.account.interfaces.controller;

import com.alibaba.excel.EasyExcel;
import com.chomolungma.common.result.Result;
import com.chomolungma.core.CurrentProfileHolder;
import com.chomolungma.core.application.service.ExcelService;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.account.application.service.AccountService;
import com.chomolungma.system.account.domain.assembler.AccountAssembler;
import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.domain.repository.IAccountRepository;
import com.chomolungma.system.account.infrastructure.converter.AccountUserConverter;
import com.chomolungma.system.account.infrastructure.dataobject.AccountUserRoleDO;
import com.chomolungma.system.account.infrastructure.listener.AccountExcelListener;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.account.interfaces.dto.AccountExcelDTO;
import com.chomolungma.system.account.interfaces.dto.AccountInDTO;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.staff.application.service.StaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService accountService;
    private final IAccountRepository iAccountRepository;
    private final ExcelService excelService;

    private final StaffService staffService;

    public AccountController(AccountService accountService, IAccountRepository iAccountRepository, ExcelService excelService, StaffService staffService) {
        this.accountService = accountService;
        this.iAccountRepository = iAccountRepository;
        this.excelService = excelService;
        this.staffService = staffService;

    }

    @GetMapping("/get")
    public Map<String, Object> getProfile(){
        List<MenuDTO> menuDTOS = staffService.getMenus(CurrentProfileHolder.getProfile().getRoleIds());
        Map<String, Object> map = new HashMap<>();
        map.put("roles", CurrentProfileHolder.getProfile().getPermissions());
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");
        map.put("menus", menuDTOS);
        map.put("code",200);
        return map;
    }

    @GetMapping
    public Result getPageList(PageDTO pageDTO,
                              @RequestParam(required = false) String username,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String nickname,
                              @RequestParam(required = false) Boolean enabled){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername(username);
        accountDTO.setName(name);
        accountDTO.setNickname(nickname);
        accountDTO.setEnabled(enabled);
        return Result.success(iAccountRepository.queryPageList(AccountAssembler.toEntity(accountDTO),pageDTO.getPage(), pageDTO.getLimit()));
    }

    @GetMapping("/{id}")
    // @PreAuthorize("hasAuthority('system:account:view')")
    public Result getAccount(@PathVariable("id") Long id){
        Account account = iAccountRepository.findAccount(id);
        return Result.success(AccountAssembler.toDTO(account));
    }

    @PostMapping
   // @PreAuthorize("hasAuthority('system:account:add')")
    public Result createAccount(@RequestBody AccountInDTO accountInDTO){
        Account account = AccountAssembler.toEntity(accountInDTO);
        accountService.createAccount(account);
        return Result.success();
    }

    @PutMapping
   // @PreAuthorize("hasAuthority('system:account:edit')")
    public Result updateAccount(@RequestBody AccountInDTO accountInDTO){
        Account account = AccountAssembler.toEntity(accountInDTO);
        accountService.updateAccount(account);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
   // @PreAuthorize("hasAuthority('system:account:delete')")
    public Result deleteAccount(@PathVariable("ids") String ids){
        iAccountRepository.remove(Arrays.asList(ids.split(",")));
        return Result.success();
    }

    @PutMapping("/password/{id}")
   // @PreAuthorize("hasAuthority('system:account:reset')")
    public Result resetPassword(@PathVariable("id") Long id){
        accountService.resetPassword(id);
        return Result.success();
    }

    @PutMapping("/{id}/user/{userId}")
   // @PreAuthorize("hasAuthority('system:account:bind')")
    public Result bindUser(@PathVariable("id") Long id, @PathVariable("userId") Long userId){
        accountService.bindUser(id, userId);
        return Result.success();
    }


    @PostMapping("/import")
    @Transactional
   // @PreAuthorize("hasAuthority('system:account:import')")
    public void importExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), AccountExcelDTO.class, new AccountExcelListener(iAccountRepository, excelService)).sheet().doRead();
    }

    @GetMapping("/export")
   // @PreAuthorize("hasAuthority('system:account:export')")
    public void export(AccountDTO accountDTO) throws IOException {
        List<Account> accountEntities = accountService.getAccounts(AccountAssembler.toEntity(accountDTO));
        excelService.export(AccountAssembler.toExcelDTO(accountEntities), AccountExcelDTO.class);
    }
}
