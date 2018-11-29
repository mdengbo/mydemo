package com.example.easypoiexcel.rep.service.impl;

import com.example.easypoiexcel.entity.AppAndFile;
import com.example.easypoiexcel.entity.Application;
import com.example.easypoiexcel.excelDTO.AppFileDTO;
import com.example.easypoiexcel.rep.dao.ApplicationMapper;
import com.example.easypoiexcel.rep.example.ApplicationExample;
import com.example.easypoiexcel.rep.service.api.ApplicationService;
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
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationMapper applicationMapper;


    @Override
    public List<Application> getAllApp() {

        ApplicationExample applicationExample = new ApplicationExample();

        applicationExample.createCriteria().andIdIsNotNull();

        return applicationMapper.selectByExample(applicationExample);
    }

    @Override
    public List<AppFileDTO> getAllAppFile() {
        return applicationMapper.getAppFile();
    }

    @Override
    public List<AppAndFile> selectAppAndFile() {

        return applicationMapper.selectAppAndFile();
    }
}
