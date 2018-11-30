package com.example.easypoiexcel.csv;

import cn.afterturn.easypoi.csv.CsvExportUtil;
import cn.afterturn.easypoi.csv.CsvImportUtil;
import cn.afterturn.easypoi.csv.entity.CsvExportParams;
import cn.afterturn.easypoi.csv.entity.CsvImportParams;
import com.example.easypoiexcel.entity.FileUserNum;
import com.example.easypoiexcel.rep.service.api.FileUSerNumService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CsvTests {

    @Autowired
    FileUSerNumService fileUSerNumService;

    @Test
    public void contextLoads() {
    }

    /************************
     *
     * CSV  导入import
     *
     * **************/
    @Test
    public void exportCsv() {

        List<FileUserNum> FileUserNums = fileUSerNumService.getAllNum();
        CsvExportParams params = new CsvExportParams();
        try {
            //CsvExportParams params, Class<?> pojoClass,
            //                                 Collection<?> dataSet, OutputStream outputStream
            File savefile = new File("D:/excel/");

            if (!savefile.exists()) {
                savefile.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream("D:/excel/FileUserNum.csv");
            //解决csv乱码  写入bom头
            byte[] uft8bom={(byte)0xef,(byte)0xbb,(byte)0xbf};
            fos.write(uft8bom);

            CsvExportUtil.exportCsv(params, FileUserNum.class, FileUserNums, fos);
            fos.flush();
            fos.close();
            log.info("导出完成");
        } catch (Exception e) {
            log.error("导出异常 exception: {}", e);
            e.printStackTrace();
        }
    }

    /************************
     *
     * CSV  导入import
     *
     * **************/

    @Test
    public void importCsv() {

        CsvImportParams params = new CsvImportParams(CsvImportParams.UTF8);
        String filePath="D:\\excel\\FileUserNum.csv";
        try {
            List<FileUserNum> FileUserNum = CsvImportUtil.importCsv(new FileInputStream(new File(filePath)), FileUserNum.class, params);
            //todo save data
            log.info("导出完成 num: {}",FileUserNum.size());
        } catch (Exception e) {
            log.error("导出异常 exception: {}", e);
            e.printStackTrace();
        }
    }

    /**
     * 导入 csv 并进行相应保存操作
     * */
    @Test
    public void importCsvSave() {

        CsvImportParams params = new CsvImportParams(CsvImportParams.UTF8);
        String filePath="D:\\excel\\FileUserNum.csv";
        try {
            //此处 importCsv  每读取一行就去处理一行数据
            CsvImportUtil.importCsv(new FileInputStream(new File(filePath)), FileUserNum.class, params, new CsvSave());
            //todo save data
            log.info("导出完成 num: {}");
        } catch (Exception e) {
            log.error("导出异常 exception: {}", e);
            e.printStackTrace();
        }
    }

}
