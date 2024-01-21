package com.chomolungma.core.service;

import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collection;

@Service
public class ExcelServiceImpl implements ExcelService{

    @Autowired
    private HttpServletResponse response;

    @Override
    public void export(Collection<?> t, Class clazz) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        export(t, clazz, System.currentTimeMillis()+"");
    }

    @Override
    public void export(Collection<?> t, Class clazz, String fileName) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8")+ ".xlsx");
        EasyExcel.write(response.getOutputStream(), clazz).autoCloseStream(Boolean.FALSE).sheet("模板").doWrite(t);

    }
}
