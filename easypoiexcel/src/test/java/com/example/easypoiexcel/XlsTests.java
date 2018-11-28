package com.example.easypoiexcel;

import cn.afterturn.easypoi.csv.CsvExportUtil;
import cn.afterturn.easypoi.csv.CsvImportUtil;
import cn.afterturn.easypoi.csv.entity.CsvExportParams;
import cn.afterturn.easypoi.csv.entity.CsvImportParams;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.example.easypoiexcel.StyleAttr.Style_xls;
import com.example.easypoiexcel.entity.FileUserNum;
import com.example.easypoiexcel.excelDTO.AppFileDTO;
import com.example.easypoiexcel.importEntity.FileUserNumImp;
import com.example.easypoiexcel.rep.service.api.ApplicationService;
import com.example.easypoiexcel.rep.service.api.FileUSerNumService;
import com.example.easypoiexcel.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

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

    /**
     * 导入 csv
     * */
    @Test
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
    @Test
    public void exportExcelMergeLocal() {

        List<AppFileDTO> allApp = applicationService.getAllAppFile();
        //导出的一些参数设置
        fileName = "allApp.xlsx";
        saveFile = filePath + fileName;
        try {
            //Workbook workbook = ExcelExportUtil.exportExcel(params, AppFileDTO.class, allApp);
            //设置文件名 文件标题 ,ExcelType.XSSF/ExcelType.HSSF=》可以导出 .xlsx
            ExportParams exportParams = new ExportParams("对应应用的文件", "文件月下载量",ExcelType.HSSF);
            //设置style
            exportParams.setStyle(Style_xls.class);

            Workbook workbook = ExcelExportUtil.exportExcel(exportParams,
                    AppFileDTO.class, allApp);

            FileOutputStream fos = new FileOutputStream(
                    //FileUtilTest.getWebRootPath("import/sameName.xls")
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

}
