package com.example.easypoiexcel.excelDTO;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.example.easypoiexcel.entity.FileUserNum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@ExcelTarget("AppFileDTO")
@Data
public class AppFileDTO implements Serializable {


    @Excel(name = "应用Id", height = 20, width = 30, isImportField = "true", needMerge = true)
    private String appId;

    @Excel(name = "应用名称", orderNum = "2", needMerge = true )
    private String name;
    /**
     * orderNum = "6" 表示该列从第几列开始输入 默认/不填 从 0 列开始
     * 如果orderNum超过实际需要的列 则从实际列开始（假如只需要3列即可  当填 orderNum =4 仍然从第 3 列开始）
     * */
    @ExcelCollection(name = "应用文件月统计", orderNum = "2")
    private List<FileUserNum> fileUserNums;

}