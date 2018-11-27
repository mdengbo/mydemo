package com.example.easypoiexcel.comm;

import cn.afterturn.easypoi.excel.entity.ExportParams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SheetsAttr {

    /**
     * 包含一些文件属性 title name
     * */
    private ExportParams exportParams;

    /** map 中的属性
     * title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName
        dataMap1.put("title",params1) ;
     模版导出对应得实体类型
        dataMap1.put("entity",FileUserNum .class) ;
     sheet中要填充得数据
        dataMap1.put("data",fileUserNums) ;
     */

    private Map map = new HashMap<>();

    public ExportParams getExportParams() {
        return exportParams;
    }

    public void setExportParams(ExportParams exportParams) {
        this.exportParams = exportParams;
    }

    public Map getMap() {
        return map;
    }
    /**
     * 通过setMap 设置各个属性
     * */
    public  void setMap(ExportParams exportParams, Class<?> pojoClass, List<?> dateLists) {
        this.exportParams = exportParams;
        this.map.put("title",exportParams);
        this.map.put("entity",pojoClass);
        this.map.put("data",dateLists);
    }
}
