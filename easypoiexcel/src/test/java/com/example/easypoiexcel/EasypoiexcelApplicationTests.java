package com.example.easypoiexcel;

import cn.afterturn.easypoi.csv.CsvExportUtil;
import cn.afterturn.easypoi.csv.entity.CsvExportParams;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.easypoiexcel.entity.FileUserNum;
import com.example.easypoiexcel.rep.service.api.FileUSerNumService;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasypoiexcelApplicationTests {

    @Autowired
    FileUSerNumService fileUSerNumService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void excelContextLoads() {

        List<FileUserNum> FileUserNums = fileUSerNumService.getAllNum();

        /*Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("文件统计数量月报","文件月报"),
                FileUserNum.class, FileUserNums);*/

        Date start = new Date();
        CsvExportParams params = new CsvExportParams();
        params.setEncoding(CsvExportParams.GBK);

        File savefile = new File("D:/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream("D:/excel/FileUserNum.csv");
            CsvExportUtil.exportCsv(params, FileUserNum.class, FileUserNums, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("导出完成" + (new Date().getTime() - start.getTime()));
    }

}
