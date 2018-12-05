package com.example.easypoiexcel.rep.dao;

import com.example.easypoiexcel.entity.DateTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author madengbo
 * @create 2018-12-04 16:53
 * @desc
 * @Version 1.0
 **/
@Repository
@Mapper
public interface SaveMapper {

    void save(List<DateTest> dateTestList);

    void save01(DateTest dateTestList);

}
