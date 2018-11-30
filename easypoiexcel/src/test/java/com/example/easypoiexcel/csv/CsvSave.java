package com.example.easypoiexcel.csv;

import cn.afterturn.easypoi.csv.handler.ICsvSaveDataHandler;
import com.example.easypoiexcel.entity.FileUserNum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author madengbo
 * @create 2018-11-30 08:44
 * @desc
 * @Version 1.0
 **/
@Slf4j
public class CsvSave implements ICsvSaveDataHandler<FileUserNum> {


   //保存数据 每读取一行就去处理一行
    @Override
    public void save(FileUserNum fileUserNum) {
       log.info("传如数据 date={}",fileUserNum.toString());
    }
}
