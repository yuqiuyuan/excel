package com.drebander.excel.service.impl;

import com.drebander.excel.service.SjtyExcelService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@Service
public class SjtyExcelServiceImpl implements SjtyExcelService {
    public static void main(String[] args) throws Exception {
        File f = new File("/Users/drebander/Documents/test.xlsx");
        SjtyExcelServiceImpl s = new SjtyExcelServiceImpl();
        s.anaylizeVoFromExcel(new FileInputStream(f));
    }

    @Override
    public String anaylizeVoFromExcel(FileInputStream excelFile) {
        Workbook wb = null;
        try {
            wb = new XSSFWorkbook(excelFile);
            Sheet sheet = wb.getSheetAt(0);//获取第一张表
            Iterator<Row> rowIt = sheet.rowIterator();
            while (rowIt.hasNext()) {
                Row row = rowIt.next();
                String v = row.getCell(0).getStringCellValue();
                System.out.println(v);//获取表格内第一个单元的值
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                wb.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
