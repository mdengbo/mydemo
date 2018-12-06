package com.example.easypoiexcel.comm;

import cn.afterturn.easypoi.excel.entity.ExportParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @Author:mdengbo 2018/11/28
 * 多文件属性设置
 * */
public class SheetsAttr {

    private List<Map<String, Object>> sheets = new ArrayList<>() ;


    public List<Map<String, Object>> getListMap() {
        return sheets;
    }

    /**
     * @param exportParams 导出参数设置
     * @param pojoClass 对应实体类
     * @param dateLists 数据lists
     */

    public void addListMap(ExportParams exportParams, Class<?> pojoClass, List<?> dateLists) {
        /** map 中的属性
         * title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName
         dataMap1.put("title",params1) ;
         模版导出对应得实体类型
         dataMap1.put("entity",FileUserNum .class) ;
         sheet中要填充得数据
         dataMap1.put("data",fileUserNums) ;
         */
        Map map = new HashMap<>();
        map.put("title",exportParams);
        map.put("entity",pojoClass);
        map.put("data",dateLists);
        sheets.add(map);
    }


}
