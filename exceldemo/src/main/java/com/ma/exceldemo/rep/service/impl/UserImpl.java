package com.ma.exceldemo.rep.service.impl;

import com.ma.exceldemo.entity.User;
import com.ma.exceldemo.rep.dao.UserMapper;
import com.ma.exceldemo.rep.example.UserExample;
import com.ma.exceldemo.rep.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author madengbo
 * @create 2018-11-15 14:54
 * @desc
 * @Version 1.0
 **/
@Slf4j
@Service
public class UserImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUseridIsNotNull();

        return userMapper.selectByExample(userExample);
    }
}
