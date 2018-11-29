package com.example.easypoiexcel;

import cn.afterturn.easypoi.pdf.PdfExportUtil;
import cn.afterturn.easypoi.pdf.entity.PdfExportParams;
import com.example.easypoiexcel.StyleAttr.Style_pdf;
import com.example.easypoiexcel.entity.FileUserNum;
import com.example.easypoiexcel.rep.service.api.FileUSerNumService;
import com.itextpdf.text.Document;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PdfTests {

    @Autowired
    FileUSerNumService fileUSerNumService;

    @Test
    public void contextLoads() {
    }

    /**
     * 导出 csv
     * */
    @Test
    public void exportPdf() {

        List<FileUserNum> FileUserNums = fileUSerNumService.getAllNum();
        PdfExportParams params = new PdfExportParams("testExportPdf001","testExportPdf002");
        try {
            File file = new File("D:/excel/testExportPdf.pdf");
            file.createNewFile();
            //设置样式
            Style_pdf stylePdf = new Style_pdf();
            params.setStyler(stylePdf);
            Document document =  PdfExportUtil.exportPdf(params, FileUserNum.class, FileUserNums,new FileOutputStream(file));
            log.info("导出完成");
        } catch (Exception e) {
            log.error("导出异常 exception: {}", e);
            e.printStackTrace();
        }
    }


}
