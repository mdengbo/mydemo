package com.example.easypoiexcel.word;

import cn.afterturn.easypoi.word.WordExportUtil;
import cn.afterturn.easypoi.word.entity.params.ExcelListEntity;
import com.example.easypoiexcel.Utils.ListToMapUtils;
import com.example.easypoiexcel.entity.FileUserNum;
import com.example.easypoiexcel.rep.service.api.FileUSerNumService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * @author madengbo
 * @create 2018-11-30 17:07
 * @desc
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestListToMap {

    @Autowired
    FileUSerNumService fileUSerNumService;

    @Test
    public void test(){
        List<FileUserNum> allNum = fileUSerNumService.getAllNum();
        ListToMapUtils.getKeysAndValues(allNum);
        log.info("success: {}", 1+1);
    }

    /**
     * 简单导出没有图片和Excel
     */
    @Test
    public void SimpleWordExport() {
        List<FileUserNum> allNum = fileUSerNumService.getAllNum();
        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("FileUserNums",new ExcelListEntity(allNum, FileUserNum.class));
        map.put("FileUserNums",allNum);
        try {
            File savefile = new File("D:\\excel\\word");
            if (!savefile.exists()) {
                savefile.mkdirs();
            }
            XWPFDocument doc = WordExportUtil.exportWord07(
                    "public/word/FileUserNum.docx", map);
            FileOutputStream fos = new FileOutputStream("D:/excel/word/FileUserNums.docx");
            doc.write(fos);
            fos.close();
            log.info("导出完成，导出数量={}",allNum.size());
        } catch (Exception e) {
            log.error("导出异常 = {}", e);
            e.printStackTrace();
        }
    }

    /**
     * 简单导出没有图片和Excel
     */
    @Test
    public void SimpleWordExport01() {
        List<FileUserNum> allNum = fileUSerNumService.getAllNum();
        Map<String, Object> map = ListToMapUtils.getKeyAndValue(allNum.get(0));
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                    "public/word/singleFileUserNum.docx", map);
            FileOutputStream fos = new FileOutputStream("D:/excel/word/singleFileUserNums.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
