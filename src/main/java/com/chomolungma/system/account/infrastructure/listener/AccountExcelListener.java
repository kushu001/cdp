package com.chomolungma.system.account.infrastructure.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.chomolungma.core.application.service.ExcelService;
import com.chomolungma.system.account.domain.assembler.AccountAssembler;
import com.chomolungma.system.account.interfaces.dto.AccountExcelDTO;
import com.chomolungma.system.account.domain.repository.IAccountRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountExcelListener implements ReadListener<AccountExcelDTO> {

    private IAccountRepository iAccountRepository;

    private ExcelService excelService;
    List<AccountExcelDTO> results = new ArrayList<>();
    public AccountExcelListener(IAccountRepository iAccountRepository, ExcelService excelService) {
        this.iAccountRepository = iAccountRepository;
        this.excelService =  excelService;
    }

    @Override
    public void invoke(AccountExcelDTO accountExcelDTO, AnalysisContext analysisContext) {
        try
        {
            iAccountRepository.save(AccountAssembler.toEntity(accountExcelDTO));
            results.add(accountExcelDTO);
        } catch (Exception ex) {
            System.err.println(Arrays.toString(ex.getStackTrace()));
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        try {
            excelService.export(results, AccountExcelDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
