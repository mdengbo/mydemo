package com.example.easypoiexcel.comm;

import cn.afterturn.easypoi.excel.entity.ExportParams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: mdengbo
 * 设置多表导出的属性
 * */

public class SetSheetsAttr {

    public static List<Map<String, Object>> dealSheetsAttr(List<SheetsAttr> sheetsAttrs){
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        if(null != sheetsAttrs && sheetsAttrs.size()>0){
            for(SheetsAttr sheet : sheetsAttrs){
                sheetsList.add(sheet.getMap());
            }
        }
        return sheetsList;
    }



}
