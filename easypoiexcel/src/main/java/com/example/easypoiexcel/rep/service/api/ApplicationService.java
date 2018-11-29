package com.example.easypoiexcel.rep.service.api;

import com.example.easypoiexcel.entity.AppAndFile;
import com.example.easypoiexcel.entity.Application;
import com.example.easypoiexcel.entity.FileUserNum;
import com.example.easypoiexcel.excelDTO.AppFileDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author madengbo
 * @create 2018-11-27 09:47
 * @desc
 * @Version 1.0
 **/

public interface ApplicationService {

    List<Application> getAllApp();

    List<AppFileDTO> getAllAppFile();

    List<AppAndFile> selectAppAndFile();
}
