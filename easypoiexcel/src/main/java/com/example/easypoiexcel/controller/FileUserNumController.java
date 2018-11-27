package com.example.easypoiexcel.controller;

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
import com.sun.deploy.net.URLEncoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author madengbo
 * @create 2018-11-27 09:54
 * @desc
 * @Version 1.0
 **/
@RestController
@RequestMapping("/fileController")
@Slf4j
public class FileUserNumController {

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
            FileUtil.exportExcel(FileUserNums,"文件下载月报统计","文件统计",FileUserNum.class,"FileUserNum.xls",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getAllFileNumWorkSheet")
    public void getAllFileNumWorkSheet(HttpServletResponse response) {

        List<FileUserNum> FileUserNums = fileUSerNumService.getAllNum();

        //Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("测试", "测试"), FileUserNum.class , FileUserNums);

        try {
            FileUtil.exportExcel(FileUserNums,"文件下载月报统计","文件统计",FileUserNum.class,"文件下载111月报统计",true,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * 导入
    * */
    @RequestMapping("/importExcel")
    public void importExcel(){
        //需要导入的文件绝对路径
        String filePath = "D:\\excel\\FileUserNum.xls";
        //解析excel，
        try {
            List<FileUserNum> fileUserNum = FileUtil.importExcel(filePath,1,1,FileUserNum.class);
            log.info("导入数据一共 {} 行",fileUserNum.size());
            //TODO 保存数据库
        } catch (Exception e) {
            e.printStackTrace();
        }
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入

    }

    /**
     * 多表导出、合并单元格
    * **/

    @RequestMapping("/exportExcelMerge")
    public void  exportExcelMerge(HttpServletResponse response){

        List<AppFileDTO> allApp = applicationService.getAllAppFile();
        try {
            FileUtil.exportExcel(allApp,"应用文件下载月报统计","文件统计",AppFileDTO.class,"AppFileDTO.xls",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //mdengbo 设置文件存放路径
    private  String filePath = "D:\\excel\\";
    //设置文件名
    private  String fileName = "";

    //文件存放路径 本案例 saveFile = filePath + fileName
    private String saveFile="";

    /**
     * 保存到本地
     * */
    @RequestMapping("/exportExcelMergeLocal")
    public String  exportExcelMergeLocal(HttpServletResponse response){

        List<AppFileDTO> allApp = applicationService.getAllAppFile();
        //导出的一些参数设置
        ExportParams params = new ExportParams();
        fileName = "allApp.xls";
        saveFile = filePath + fileName;
        try {
            //Workbook workbook = ExcelExportUtil.exportExcel(params, AppFileDTO.class, allApp);
            //设置文件名 文件标题
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("对应应用的文件","文件月下载量"),
                    AppFileDTO .class, allApp);

            FileOutputStream fos = new FileOutputStream(
                    //FileUtilTest.getWebRootPath("import/sameName.xls")
                    saveFile
            );
            workbook.write(fos);
            fos.close();
            log.info("导出完成，文件存放路径={}",saveFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            log.info("导出异常，{}",e);
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.info("导出异常，{}",e);
            e.printStackTrace();
        }

        return result.getSUCCESS();
    }

    /**
     * 模板导出
     * */
    @RequestMapping("/exportModel")
    public void exportModel(){

        fileName = "appAllList.xls";
        saveFile = filePath + fileName;

        List<FileUserNum> FileUserNums = fileUSerNumService.getAllNum();
        //引入模板
        TemplateExportParams params = new TemplateExportParams("import/FileUserNum.xls", true);
        Workbook workbook = ExcelExportUtil.exportExcel(params, FileUserNum.class, FileUserNums, new HashMap<>());
        File savefile = new File(filePath);
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream(saveFile);
            workbook.write(fos);
            fos.close();
            log.info("导出完成，文件存放路径={}",saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 模板导出 页面下载
     * */
    @RequestMapping("/exportModel02")
    public void exportModel02(HttpServletResponse response){

        fileName = "appAllList.xls";
        saveFile = filePath + fileName;
        String templateUrl = "import/FileUserNum.xls";

        List<FileUserNum> FileUserNums = fileUSerNumService.getAllNum();
        //引入模板
        try {
            FileUtil.exportExcel(FileUserNums, FileUserNum.class, fileName,templateUrl, response);
            log.info("导出完成");
        } catch (Exception e) {
            log.error("导出异常 exception={}", e);
            e.printStackTrace();
        }
    }

    /**
     * 多sheet导出
     * */
    @RequestMapping("/exportMutiExcel")
    public void exportMutiExcel(HttpServletResponse response, ModelMap modelMap){

        List<FileUserNum> fileUserNums = fileUSerNumService.getAllNum();
        List<Application> allApp = applicationService.getAllApp();

        SheetsAttr sheetsAttr = new SheetsAttr();
        ExportParams params1 = new ExportParams() ;
        params1.setSheetName("文件月报表");
        params1.setTitle("文件月报表title");
        ExportParams params2 = new ExportParams() ;
        params2.setSheetName("应用表") ;
        params2.setTitle("应用表title");
        sheetsAttr.setExportParams(params1);
        sheetsAttr.setMap(params1,FileUserNum.class,fileUserNums);

       /* // 设置导出配置
        // 创建参数对象（用来设定excel得sheet得内容等信息）
        ExportParams params1 = new ExportParams() ;
        // 设置sheet得名称
        params1.setSheetName("文件月报表");
        params1.setTitle("文件月报表title");
        ExportParams params2 = new ExportParams() ;
        params2.setSheetName("应用表") ;
        params2.setTitle("应用表title");
        // 创建sheet1使用得map
        Map dataMap1 = new HashMap<>();
        // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName
        dataMap1.put("title",params1) ;
        // 模版导出对应得实体类型
        dataMap1.put("entity",FileUserNum.class) ;
        // sheet中要填充得数据
        dataMap1.put("data",fileUserNums) ;
        // 创建sheet2使用得map
        Map dataMap2 = new HashMap<>();
        dataMap2.put("title",params2) ;
        dataMap2.put("entity",Application.class) ;
        dataMap2.put("data",allApp) ;
        // 将sheet1和sheet2使用得map进行包装
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        sheetsList.add(dataMap1);
        sheetsList.add(dataMap2);

        Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            try {
                throw new Exception(e.getMessage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }*/
        }



}
