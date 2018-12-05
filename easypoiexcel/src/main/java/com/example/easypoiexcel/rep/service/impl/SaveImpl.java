package com.example.easypoiexcel.rep.service.impl;

import com.example.easypoiexcel.entity.DateTest;
import com.example.easypoiexcel.entity.FileUserNum;
import com.example.easypoiexcel.rep.dao.FileUserNumMapper;
import com.example.easypoiexcel.rep.dao.SaveMapper;
import com.example.easypoiexcel.rep.example.FileUserNumExample;
import com.example.easypoiexcel.rep.service.api.FileUSerNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author madengbo
 * @create 2018-11-27 09:49
 * @desc
 * @Version 1.0
 **/
@Service
public class SaveImpl {

    @Autowired
    SaveMapper saveMapper;

    public void save(DateTest dateTestList) {
       saveMapper.save01(dateTestList);

    }
}
