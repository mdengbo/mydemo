package com.example.easypoiexcel;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * @author madengbo
 * @create 2019-01-18 15:14
 * @desc
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class pdftowordtest {

    @Test
    public void TestPDFBox(){

        File file = new File("E:\\zhongkehengyun\\personal\\高项资料\\18年下半年高项(1)\\第一阶段\\08讲-【第四章】项目整体管理【第16章】变更管理\\08讲-【第四章】项目整体管理【第16章】变更管理.pdf");
        try {
            PDDocument doc = PDDocument.load(file);
            int pagenumber = doc.getNumberOfPages();
            System.out.print("pages"+pagenumber);
            FileOutputStream fos = new FileOutputStream("E:\\zhongkehengyun\\personal\\高项资料\\18年下半年高项(1)\\第一阶段\\word\\08讲-【第四章】项目整体管理【第16章】变更管理08讲-【第四章】项目整体管理【第16章】变更管理.doc");
            Writer writer = new OutputStreamWriter(fos, "UTF-8");
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);//排序
            //stripper.setStartPage(0);//设置转换的开始页
            //stripper.setEndPage(7);//设置转换的结束页
            stripper.writeText(doc,writer);
            writer.close();
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
