package com.rt.demo.service.impl;

import com.rt.demo.dao.DemoMapper;
import com.rt.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName DemoServiceImpl
 * @Author Ray
 * @Date 2021/1/26 14:42
 * @Description
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;
    @Override
    public Integer insert() {
        Integer insert = demoMapper.insert();
        return insert;
    }
}
