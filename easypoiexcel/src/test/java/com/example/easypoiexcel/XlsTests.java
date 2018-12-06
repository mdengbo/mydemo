package com.example.easypoiexcel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.example.easypoiexcel.StyleAttr.ExcelExportStatisticStyler;
import com.example.easypoiexcel.StyleAttr.Style_xls;
import com.example.easypoiexcel.entity.AppAndFile;
import com.example.easypoiexcel.entity.FileUserNum;
import com.example.easypoiexcel.excelDTO.AppFileDTO;
import com.example.easypoiexcel.rep.service.api.ApplicationService;
import com.example.easypoiexcel.rep.service.api.FileUSerNumService;
import com.example.easypoiexcel.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * xls是Excel997-2003的格式，xlsx是Excel 2007之后版本创建的格式。
 *
 * 两种版本在保存时编码不一样。而且Excel 2007之后的版本增加了新的系统函数，更加方便和实用。
 *
 * xlsx后缀名比xls后缀名的文件更节约空间，而且运算速度也会快一点
 *
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class XlsTests {

    //mdengbo 设置文件存放路径
    private String filePath = "D:\\excel\\";
    //设置文件名

    private String fileName = new Date().toString() + ".xls";

    //文件存放路径 本案例 saveFile = filePath + fileName
    private String saveFile = "";

    @Autowired
    FileUSerNumService fileUSerNumService;

    @Autowired
    ApplicationService applicationService;

    @Test
    public void contextLoads() {
    }

    /****************************
     *
     * 导入 public
     *
     ******************* */
    @Test
    public void importExcel() {
        //需要导入的文件绝对路径
        String filePath = "D:\\excel\\FileUserNum.xls";
        //解析excel，
        try {
            List<FileUserNum> fileUserNum = FileUtil.importExcel(filePath, 4, 1, FileUserNum.class);
            log.info("导入数据一共 {} 行", fileUserNum.size());
            //TODO 保存数据库
        } catch (Exception e) {
            e.printStackTrace();
        }
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入

    }


    /*****************************
     *
     * 导出 export
     * 如果对于样式有比较严格的要求的话   建议采用模板导出
     *
     ******************* */


    @Test
    public void exportExcelMergeLocal() {

        List<AppFileDTO> allApp = applicationService.getAllAppFile();
        //导出的一些参数设置
        fileName = "allApp.xls";
        saveFile = filePath + fileName;
        try {
            //Workbook workbook = ExcelExportUtil.exportExcel(params, AppFileDTO.class, allApp);
            //设置文件名 文件标题 ,ExcelType.XSSF/ExcelType.HSSF=》可以导出 .xlsx  office7 打开可能出现问题
            ExportParams exportParams = new ExportParams("对应应用的文件", "文件月下载量",ExcelType.HSSF);
            //ExportParams exportParams = new ExportParams("文件月下载量",ExcelType.HSSF);
            //设置style   当数据单元格为空 null 时样式不显示  可以通过定义模板导出
            //exportParams.setStyle(Style_xls.class);
            exportParams.setStyle(ExcelExportStatisticStyler.class);

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

    }

    @Test
    public void exportExcelAppAndFile() {

        List<AppAndFile> appAndFile = applicationService.selectAppAndFile();
        //导出的一些参数设置
        fileName = "appAndFile.xls";
        saveFile = filePath + fileName;
        try {
            //Workbook workbook = ExcelExportUtil.exportExcel(params, AppFileDTO.class, allApp);
            //设置文件名 文件标题 ,ExcelType.XSSF/ExcelType.HSSF=》可以导出 .xlsx  office7 打开可能出现问题
            ExportParams exportParams = new ExportParams("对应应用的文件", "文件月下载量",ExcelType.HSSF);
            //设置style   当数据单元格为空 null 时样式不显示  可以通过定义模板导出
            exportParams.setStyle(Style_xls.class);
            Workbook workbook = ExcelExportUtil.exportExcel(exportParams,
                    AppAndFile.class, appAndFile);

            FileOutputStream fos = new FileOutputStream(
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

    }


    /**
     * 模板导出  保证样式 .xlsx  如果office打开可能存在问题  但是wps打开没问题  可能是模板问题
     * 注意：excel 版本
     *          07版模板.xlsx    03版  .xls
     * */
    @Test
    public void exportByModel() {

        fileName = "FileUserNum.xls";
        saveFile = filePath + fileName;

        List<FileUserNum> FileUserNums = fileUSerNumService.getAllNum();
        //引入模板
        TemplateExportParams params = new TemplateExportParams("public/xls/FileUserNum.xls", true);
        //根据模板设置数据写入位置
        //设置表头开始位置
        params.setHeadingStartRow(1);
        //设置表头占用的行数 数据将从 第五行 开始写入
        params.setHeadingRows(4);

        Workbook workbook = ExcelExportUtil.exportExcel(params, FileUserNum.class, FileUserNums, new HashMap());
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


    @Test
    public void test() {
        try {
            ImportParams params = new ImportParams();
            params.setKeyMark("：");
            params.setReadSingleCell(true);
            //设置标题列（此处标题 是指映射的标题）
            params.setTitleRows(7);
            //LastOfInvalidRow 指的是 文件体末尾开始不需要读入 目前标题映射的中数据的行数
            //params.setLastOfInvalidRow(8);
            //ReadRows 表示 从标题下开始读取数据的行数  默认为 0 开始
            params.setReadRows(9);
            ExcelImportResult<Map> result = ExcelImportUtil.importExcelMore(
                    new File("public/word/业务委托单.xlsx"),
                    Map.class, params);
            for (int i = 0; i < result.getList().size(); i++) {
                System.out.println(result.getList().get(i));
            }
            Assert.assertTrue(result.getList().size() == 10);
            System.out.println(result.getMap());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }


}
