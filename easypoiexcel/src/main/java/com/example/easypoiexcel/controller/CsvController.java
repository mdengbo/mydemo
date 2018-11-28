package com.example.easypoiexcel.controller;

import cn.afterturn.easypoi.csv.CsvExportUtil;
import cn.afterturn.easypoi.csv.entity.CsvExportParams;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.example.easypoiexcel.comm.SheetsAttr;
import com.example.easypoiexcel.entity.Application;
import com.example.easypoiexcel.entity.FileUserNum;
import com.example.easypoiexcel.excelDTO.AppFileDTO;
import com.example.easypoiexcel.rep.service.api.ApplicationService;
import com.example.easypoiexcel.rep.service.api.FileUSerNumService;
import com.example.easypoiexcel.utils.FileUtil;
import com.example.easypoiexcel.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author madengbo
 * @create 2018-11-27 09:54
 * @desc .xls 类型导出
 * @Version 1.0
 **/
@RestController
@RequestMapping("/csv")
@Slf4j
public class CsvController {

}

/**
 * 1， 导入： 考虑上传导入  （注意乱码问题） ok
 * 2， 导出pdf
 * 3， 过时 工具类 找到替换的方法
 * 4， 支持导出的格式  csv xlsx ....
 * 5,  导出/导入文件名 乱码问题。
 */