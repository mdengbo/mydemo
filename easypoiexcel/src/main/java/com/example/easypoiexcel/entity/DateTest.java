package com.example.easypoiexcel.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author madengbo
 * @create 2018-12-04 16:45
 * @desc
 * @Version 1.0
 **/
@Data
@ExcelTarget("DateTest")
public class DateTest {

    @Excel(name = "id")
    private String  id;

    @Excel(name = "name")
    private String name;

    private String code;

    private String longitude;

    private String latitude;

    private String parent_id;

    private int order_num = 0;

    private String tree_path;

    private String full_name;

    private String create_time;

    private int create_user = 1;

    private String update_time;

    private int update_user = 1;


}
