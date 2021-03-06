package com.example.easypoiexcel.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.example.easypoiexcel.StyleAttr.Style_xls;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author madengbo
 * @create 2018-11-27 09:54
 * @desc .xls 类型导出
 * @Version 1.0
 **/
@RestController
@RequestMapping("/xls")
@Slf4j
public class XlsController {

    @Autowired
    FileUSerNumService fileUSerNumService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    Result result;


    @RequestMapping("/getAll")
    public void getAllFileNum(HttpServletResponse response) {

        List<FileUserNum> FileUserNums = fileUSerNumService.getAllNum();

        try {
            FileUtil.exportExcel(FileUserNums, "文件下载月报统计", "文件统计", FileUserNum.class, "FileUserNum.xls", response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getAllFileNumWorkSheet")
    public void getAllFileNumWorkSheet(HttpServletResponse response) {

        List<FileUserNum> FileUserNums = fileUSerNumService.getAllNum();

        //Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("测试", "测试"), FileUserNum.class , FileUserNums);

        try {
            FileUtil.exportExcel(FileUserNums, "文件下载月报统计", "文件统计", FileUserNum.class, "文件下载111月报统计", true, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 导入
     */
    @RequestMapping("/importExcel")
    public void importExcel() {
        //需要导入的文件绝对路径
        String filePath = "D:\\excel\\FileUserNum.xls";
        //解析excel，
        try {
            List<FileUserNum> fileUserNum = FileUtil.importExcel(filePath, 1, 1, FileUserNum.class);
            log.info("导入数据一共 {} 行", fileUserNum.size());
            //TODO 保存数据库
        } catch (Exception e) {
            e.printStackTrace();
        }
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入

    }

    /**
     * 页面上传导入
     */
    @RequestMapping(value = "/importExcel02", method = RequestMethod.POST)
    public void importExcel02(HttpServletRequest request, HttpServletResponse response) {
        //解析excel，
        try {

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile("files");

            List<FileUserNum> fileUserNum = FileUtil.importExcel(multipartFile, 4, 1, FileUserNum.class);

            log.info("导入数据一共 {} 行", fileUserNum.size());
            //TODO 保存数据库
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 多表导出、合并单元格
     **/

    @RequestMapping("/exportExcelMerge")
    public void exportExcelMerge(HttpServletResponse response) {

        List<AppFileDTO> allApp = applicationService.getAllAppFile();
        try {
            //xls
            FileUtil.exportExcel(allApp, "应用文件下载月报统计", "文件统计", AppFileDTO.class, "AppFileDTO.xls", response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //mdengbo 设置文件存放路径
    private String filePath = "D:\\excel\\";
    //设置文件名

    private String fileName = new Date().toString() + ".xls";

    //文件存放路径 本案例 saveFile = filePath + fileName
    private String saveFile = "";

    /**
     * 保存到本地
     */
    @RequestMapping("/exportExcelMergeLocal")
    public String exportExcelMergeLocal(HttpServletResponse response) {

        List<AppFileDTO> allApp = applicationService.getAllAppFile();
        //导出的一些参数设置
        fileName = "allApp.xls";
        saveFile = filePath + fileName;
        try {
            //Workbook workbook = ExcelExportUtil.exportExcel(params, AppFileDTO.class, allApp);
            //设置文件名 文件标题
            ExportParams exportParams = new ExportParams("对应应用的文件", "文件月下载量");
            //设置style
            exportParams.setStyle(Style_xls.class);

            Workbook workbook = ExcelExportUtil.exportExcel(exportParams,
                    AppFileDTO.class, allApp);


            FileOutputStream fos = new FileOutputStream(
                    //FileUtilTest.getWebRootPath("public/sameName.xls")
                    saveFile
            );
            workbook.write(fos);
            fos.close();
            log.info("导出完成，文件存放路径={}", saveFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            log.info("导出异常，{}", e);
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.info("导出异常，{}", e);
            e.printStackTrace();
        }

        return result.getSUCCESS();
    }

    /**
     * 模板导出
     */
    @RequestMapping("/exportModel")
    public void exportModel() {

        fileName = "appAllList.xls";
        saveFile = filePath + fileName;

        List<FileUserNum> FileUserNums = fileUSerNumService.getAllNum();
        //引入模板
        TemplateExportParams params = new TemplateExportParams("public/xls/FileUserNum.xls", true);

        //不推荐 可能出血样式问题
        //Workbook workbook = ExcelExportUtil.exportExcel(params, FileUserNum.class, FileUserNums, new HashMap<>());

        Map<String, Object> map = new HashMap<>();
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);

        File savefile = new File(filePath);
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream(saveFile);
            workbook.write(fos);
            fos.close();
            log.info("导出完成，文件存放路径={}", saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模板导出 页面下载
     */
    @RequestMapping("/exportModel02")
    public void exportModel02(HttpServletResponse response) {

        fileName = "appAllList.xls";
        saveFile = filePath + fileName;
        String templateUrl = "public/xls/FileUserNum.xls";

        List<FileUserNum> FileUserNums = fileUSerNumService.getAllNum();
        //引入模板
        try {
            FileUtil.exportExcel(FileUserNums, FileUserNum.class, fileName, templateUrl, response);
            log.info("导出完成");
        } catch (Exception e) {
            log.error("导出异常 exception={}", e);
            e.printStackTrace();
        }
    }

    /**
     * 多sheet导出
     */
    @RequestMapping("/exportMutiExcel")
    public void exportMutiExcel(HttpServletResponse response) {

        //设置表名
        fileName = "文件数量导出.xlsx";

        List<FileUserNum> fileUserNums = fileUSerNumService.getAllNum();
        List<Application> allApp = applicationService.getAllApp();
        SheetsAttr sheetsAttr = new SheetsAttr();
        //sheet1 表格设置
        ExportParams params1 = new ExportParams();
        params1.setSheetName("文件月报表");
        params1.setTitle("文件月报表title");
        //sheet2 表格设置
        ExportParams params2 = new ExportParams();
        params2.setSheetName("应用表");
        params2.setTitle("应用表title");
        sheetsAttr.addListMap(params1, FileUserNum.class, fileUserNums);
        sheetsAttr.addListMap(params2, Application.class, allApp);

        //引入模板
        try {
            FileUtil.exportExcels(sheetsAttr, fileName, ExcelType.HSSF, response);
            log.info("导出完成");
        } catch (Exception e) {
            log.error("导出异常 exception={}", e);
            e.printStackTrace();
        }
    }

}

/**
 * 1， 导入： 考虑上传导入  （注意乱码问题） ok
 * 2， 导出pdf ok
 * 3， 过时 工具类 找到替换的方法  ok
 * 4， 支持导出的格式  csv xlsx ....  ok
 * 5,  导出/导入文件名 乱码问题。 ok
 */