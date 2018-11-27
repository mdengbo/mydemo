package com.example.easypoiexcel.rep.dao;

import com.example.easypoiexcel.entity.FileUserNum;
import com.example.easypoiexcel.rep.example.FileUserNumExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FileUserNumMapper {
    int countByExample(FileUserNumExample example);

    int deleteByExample(FileUserNumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileUserNum record);

    int insertSelective(FileUserNum record);

    List<FileUserNum> selectByExample(FileUserNumExample example);

    FileUserNum selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileUserNum record, @Param("example") FileUserNumExample example);

    int updateByExample(@Param("record") FileUserNum record, @Param("example") FileUserNumExample example);

    int updateByPrimaryKeySelective(FileUserNum record);

    int updateByPrimaryKey(FileUserNum record);

    FileUserNum selectByAppId(String appId);
}