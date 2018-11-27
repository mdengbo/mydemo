package com.example.easypoiexcel.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author madengbo
 * @create 2018-11-27 16:37
 * @desc
 * @Version 1.0
 **/
@Data
@Component
public class Result {
    private  String SUCCESS = "操作成功";
    private  String FAIL = "操作失败";
    private  String msg;
}
