package com.example.easypoiexcel.html;

import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExcelToHtmlParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author madengbo
 * @create 2018-11-30 14:57
 * @desc  easypoi HTML
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ExcelOrXslToHtmlTests {

    //mdengbo 设置文件存放路径
    private String filePath = "D:\\excel\\";
    //设置文件名

    private String fileName = System.nanoTime() + ".html";

    //文件存放路径 本案例 saveFile = filePath + fileName
    private String saveFile = "";

    @Test
    public void testHtmlExport() throws IOException {

        saveFile = filePath + fileName;

        Workbook wb = new HSSFWorkbook(new FileInputStream(new File("D:\\excel\\appAndFile.xls")));
        //String html = ExcelXorHtmlUtil.excelToHtml(new ExcelToHtmlParams(wb, true, "yes"));
        //String html = ExcelXorHtmlUtil.toAllHtml(wb);
        String html = ExcelXorHtmlUtil.excelToHtml(new ExcelToHtmlParams(wb, true, 0, null));
        FileWriter fw = new FileWriter(saveFile);
        fw.write(html);
        fw.close();

    }




}
