package com.ma.exceldemo.controller;

import com.ma.exceldemo.entity.User;
import com.ma.exceldemo.rep.dao.UserMapper;
import com.ma.exceldemo.rep.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author madengbo
 * @create 2018-11-15 13:48
 * @desc 导入人员信息
 * @Version 1.0
 **/
@RestController
@Slf4j
public class DownloadInfo {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/excelUser",method = RequestMethod.GET)
    public void downloadAllClassmate(HttpServletResponse response)throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("毕业人员表");
        List<User> users = userService.findAll();
        String fileName = "users" + ".xls";
        //设置导出的文件名字
        int rowNum=1;
        //设置列名
        String [] headers={"人员编号","学名","性别","学号","专业","学生卡号","年级","籍贯","毕业学院","phone1","phone2","邮件"};
        //headers表示excel表中第一行的表头
        HSSFRow row=sheet.createRow(0);
        //excel表中添加表头
         for(int i=0;i<headers.length;i++){
         HSSFCell cell=row.createCell(i);
         HSSFRichTextString text=new HSSFRichTextString(headers[i]);
         cell.setCellValue(text);
         }
        // 在表中存放查询的数据放入对应的列
         for(User user: users){
         HSSFRow row1=sheet.createRow(rowNum);
         row1.createCell(0).setCellValue(user.getUserid());
         row1.createCell(1).setCellValue(user.getUsername());
         row1.createCell(2).setCellValue(user.getSex());
         row1.createCell(3).setCellValue(user.getBranch());
         row1.createCell(5).setCellValue(user.getIdcard());
         row1.createCell(6).setCellValue(user.getXingzhengban());
         row1.createCell(7).setCellValue(user.getJiguan());
         row1.createCell(8).setCellValue(user.getBiyezhongxue());
         row1.createCell(9).setCellValue(user.getPhone1());
         row1.createCell(10).setCellValue(user.getPhone2());
         row1.createCell(11).setCellValue(user.getEmail());
         rowNum++;
         }
         response.setContentType("application/octet-stream");
         response.setHeader("Content-disposition","attachment;filename="+fileName);
         response.flushBuffer();
         workbook.write(response.getOutputStream());
        log.info("导入完成！");
         }

    }
