package com.example.easypoiexcel.controller;

import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExcelToHtmlParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author madengbo
 * @create 2018-11-30 15:32
 * @desc
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/html")
public class HtmlController {


    //mdengbo 设置文件存放路径
    private String filePath = "D:\\excel\\";
    //设置文件名

    private String fileName = System.nanoTime() + ".html";

    //文件存放路径 本案例 saveFile = filePath + fileName
    private String saveFile = "";

    @RequestMapping("/testHtml")
    public void testHtmlExport() throws IOException {

        saveFile = filePath + fileName;

        Workbook wb = new HSSFWorkbook(new FileInputStream(new File("public/xls/FileUserNum.xls")));
        String html = ExcelXorHtmlUtil.excelToHtml(new ExcelToHtmlParams(wb, true, "yes"));
        FileWriter fw = new FileWriter(saveFile);
        fw.write(html);
        fw.close();

    }
}
