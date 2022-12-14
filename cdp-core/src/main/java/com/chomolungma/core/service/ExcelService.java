package com.chomolungma.core.service;


import java.io.IOException;
import java.util.Collection;

public interface ExcelService {
    void export(Collection<?> t, Class clazz) throws IOException;

    void export(Collection<?> t, Class clazz, String fileName) throws IOException;
}
