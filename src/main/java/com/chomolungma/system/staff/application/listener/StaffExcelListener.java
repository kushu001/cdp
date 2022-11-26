package com.chomolungma.system.staff.application.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.chomolungma.core.application.service.ExcelService;
import com.chomolungma.system.staff.domain.repository.IStaffRepository;
import com.chomolungma.system.staff.interfaces.dto.StaffExcelDTO;

public class StaffExcelListener implements ReadListener<StaffExcelDTO> {
    private String code;

    private IStaffRepository iStaffRepository;

    private ExcelService excelService;

    public StaffExcelListener(String code, IStaffRepository iStaffRepository, ExcelService excelService){
        this.code = code;
        this.iStaffRepository = iStaffRepository;
        this.excelService = excelService;
    }
    @Override
    public void invoke(StaffExcelDTO staffExcelDTO, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        
    }
}
