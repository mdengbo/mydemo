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
public class ExportImgModel {

    @Excel(name = "公司名称")
    private String companyName;
    /**
     * type:导出类型 1 是文本 2 是图片,3 是函数,10 是数字 默认是文本
     * imageType: 导出类型 1 从file读取 2 是从数据库中读取（文件形式为字符数组）     默认是文件 同样导入也是一样的
     * */
    @Excel(name = "公司LOGO", type = 2 ,width = 40 , height = 20,imageType = 2)
    private byte[] companyLogo;

    private String companyLogoUrl;

    @Excel(name = "公司地址" ,width = 60)
    private String companyAddr;

    public ExportImgModel() {
    }

    public ExportImgModel(String companyName, String companyLogoUrl, String companyAddr) {
        this.companyName = companyName;
        try {
            this.companyLogo = readInputStream(companyLogoUrl);
            log.info("图片导入成功，图片的地址为： {}", companyLogoUrl);
        } catch (Exception e) {
            log.error("图片导入失败，图片的地址为： {}, 错误原因： {}", companyLogoUrl, e);
            e.printStackTrace();
        }
        this.companyAddr = companyAddr;
    }

    /**
     * @Author: mdengbo 2018/12/05
     * 一般数据库存储的是 图片 或是 文件的 url 地址
     * @param imageUrl 图片地址（String）
     * @return  文件 图片的 字节数组
     * @throws Exception
     */
    private  byte[] readInputStream(String imageUrl) throws Exception{

        //new一个URL对象
        URL url = new URL(imageUrl);
        //打开链接
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置请求方式为"GET"
        conn.setRequestMethod("GET");
        //超时响应时间为5秒
        conn.setConnectTimeout(5 * 1000);
        //通过输入流获取图片数据
        InputStream inStream = conn.getInputStream();

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }
}
