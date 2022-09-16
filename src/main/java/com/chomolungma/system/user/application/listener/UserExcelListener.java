package com.chomolungma.system.user.application.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.chomolungma.core.application.service.ExcelService;
import com.chomolungma.system.user.domain.repository.IUserRepository;
import com.chomolungma.system.user.interfaces.dto.UserExcelDTO;

public class UserExcelListener implements ReadListener<UserExcelDTO> {
    private String code;

    private IUserRepository iUserRepository;

    private ExcelService excelService;

    public UserExcelListener(String code, IUserRepository iUserRepository, ExcelService excelService){
        this.code = code;
        this.iUserRepository = iUserRepository;
        this.excelService = excelService;
    }
    @Override
    public void invoke(UserExcelDTO userExcelDTO, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        
    }
}
