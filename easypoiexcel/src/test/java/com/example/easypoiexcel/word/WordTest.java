package com.example.easypoiexcel.word;

import cn.afterturn.easypoi.entity.ImageEntity;
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
import java.text.SimpleDateFormat;
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
public class WordTest {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd");

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
        /**
         *
         * 对于直接 存放参数 list 使用$fe 遍历是 应加上 t.属性
         * 如若通过 new ExcelListEntity() 可忽略
         * */
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

    /**
     * 简单导出包含图片
     */
    @Test
    public void imageWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("department", "");
        map.put("person", "JueYue");
        map.put("time", format.format(new Date()));
        ImageEntity image = new ImageEntity();
        image.setHeight(200);
        image.setWidth(500);
        image.setUrl("public/imgs/word/testCode.png");
        image.setType(ImageEntity.URL);
        map.put("testCode", image);
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                    "public/word/Image.docx", map);
            FileOutputStream fos = new FileOutputStream("D:/excel/image/image.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
