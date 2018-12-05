package com.example.easypoiexcel.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *  图片导出
 */
@Data
@Slf4j
public class ExportImgModel01 {

    @Excel(name = "公司名称")
    private String companyName;
    /**
     * type:导出类型 1 是文本 2 是图片,3 是函数,10 是数字 默认是文本
     * imageType: 导出类型 1 从file读取 2 是从数据库中读取（文件形式为字符数组）     默认是文件 同样导入也是一样的
     * */
    @Excel(name = "公司LOGO", type = 2 ,width = 40 , height = 20,imageType = 1)
    private String companyLogo;

    @Excel(name = "公司地址" ,width = 60)
    private String companyAddr;

    public ExportImgModel01() {
    }

    public ExportImgModel01(String companyName, String companyLogo, String companyAddr) {
        this.companyName = companyName;
        this.companyLogo = companyLogo;
        this.companyAddr = companyAddr;
    }

}
