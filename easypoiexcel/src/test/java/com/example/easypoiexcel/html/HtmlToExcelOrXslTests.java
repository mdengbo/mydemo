package com.example.easypoiexcel.html;

import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * @author madengbo
 * @create 2018-11-30 15:55
 * @desc html  装换为 excel xsl  html 中需要含有  <table/>
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HtmlToExcelOrXslTests {

    @Test
    public void htmlToExcelByIs() throws Exception {
        Workbook workbook = ExcelXorHtmlUtil.htmlToExcel(new FileInputStream(new File("D:\\excel\\sample.html")), ExcelType.XSSF);
        File savefile = new File("D:\\excel\\html");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:\\excel\\html\\sample01.xlsx");
        workbook.write(fos);
        fos.close();
        workbook = ExcelXorHtmlUtil.htmlToExcel(new FileInputStream(new File("D:\\excel\\sample.html")), ExcelType.HSSF);
        fos = new FileOutputStream("D:\\excel\\html\\sample02.xls");
        workbook.write(fos);
        fos.close();
    }

    @Test
    public void htmlToExcelByStr() throws Exception {
        StringBuilder html = new StringBuilder();
        Scanner s = new Scanner(new FileInputStream(new File("D:\\excel\\exportTemp_all.html")),"utf-8");
        while (s.hasNext()) {
            html.append(s.nextLine());
        }
        s.close();
        Workbook workbook = ExcelXorHtmlUtil.htmlToExcel(html.toString(), ExcelType.XSSF);
        File savefile = new File("D:\\excel\\html");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:\\excel\\html\\exportTemp_all01.xlsx");
        workbook.write(fos);
        fos.close();
        workbook = ExcelXorHtmlUtil.htmlToExcel(html.toString(), ExcelType.HSSF);
        fos = new FileOutputStream("D:\\excel\\html\\exportTemp_all02.xls");
        workbook.write(fos);
        fos.close();
    }
}
