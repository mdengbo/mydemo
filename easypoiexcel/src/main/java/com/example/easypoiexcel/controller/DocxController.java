package com.example.easypoiexcel.controller;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.word.WordExportUtil;
import com.example.easypoiexcel.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author madengbo
 * @create 2018-12-06 09:47
 * @desc 文档页面测试Controller
 * @Version 1.0
 **/
@RestController
@RequestMapping("/doc")
@Slf4j
public class DocxController {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd");

    /**
     * 包含图片导出
     * @param response
     */

    @RequestMapping("/docImage07")
    public void imageWordExport07(HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        String  fileName = "image.docx";
        String teplateUrl = "public/word/Image.docx";
        map.put("department", "java 拓荒者");
        map.put("person", "JueYue");
        map.put("time", format.format(new Date()));
        ImageEntity image = new ImageEntity();
        image.setHeight(200);
        image.setWidth(500);
        image.setUrl("public/imgs/word/testCode.png");
        image.setType(ImageEntity.URL);
        map.put("testCode", image);
        try {
            FileUtil.exportWordTemnplate07(fileName, teplateUrl, map, response);
            log.info("导出完成");
        } catch (Exception e) {
            log.error("导出异常 exception = {}", e);
            e.printStackTrace();
        }
    }

}
