package com.example.easypoiexcel.img;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.easypoiexcel.entity.ImportImgeModel;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by JueYue on 2017/8/25.
 */
public class ExcelImportImg {

    @Test
    public void test() {

        String path = "D:\\excel\\image\\ExcelExportHasImgTest.exportCompanyImg.xls";

        try {
            ImportParams params = new ImportParams();
            //可以设置保存的路径地址（String）  默认  保存上传的Excel目录,默认是 如 TestEntity这个类保存路径就是
            //upload/excelUpload/Test/yyyyMMddHHmss_***** 保存名称上传时间_五位随机数
            params.setNeedSave(true);
            List<ImportImgeModel> result = ExcelImportUtil.importExcel(
                    new File(path),
                    ImportImgeModel.class, params);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.get(i)));
            }
            Assert.assertTrue(result.size() == 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
