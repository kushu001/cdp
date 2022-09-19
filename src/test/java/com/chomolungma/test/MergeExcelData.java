package com.chomolungma.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MergeExcelData {
    public MergeExcelData() throws IOException {
    }

    public static void main(String[] args) throws IOException {
            List<File> allFiles = readAllFilesInPath("/Users/taoyj/Documents/1-项目管理/2-维尔利/1-系统管理/4-MDM/周凯需要修改的数据/需调整编码");
            try  {
                for (File file: allFiles) {
                    LinkedHashSet<String> codes = new LinkedHashSet<>();
                    System.out.println(file.getPath());
                    EasyExcel.read(file, MaterialData.class, new ReadListener<MaterialData>() {
                        @Override
                        public void invoke(MaterialData materialData, AnalysisContext analysisContext) {
                            System.out.println(materialData.getCode() + ":" + isNumeric(materialData.getCode()));
                            if (isNumeric(materialData.getCode())){
                                codes.add(materialData.getCode());
                            }
                        }

                        @Override
                        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                            System.out.println("编码个数为: [" + codes.size() + "]");
                            for (String code: codes) {
                                method(code);
                            }

                        }
                    }).sheet().doRead();

                }
            } catch (Exception ex) {

            }
    }


    public static List<File> readAllFilesInPath(String path) throws IOException {
        return Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
    }

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static boolean isNumeric(String str) {
        return str != null && NUMBER_PATTERN.matcher(str).matches();
    }

    public static void method(String code) {
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f = new File("/Users/taoyj/Documents/1-项目管理/2-维尔利/1-系统管理/4-MDM/周凯需要修改的数据/需要修改的编码.txt");
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(code);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
