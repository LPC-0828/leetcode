package com.rt.demo.dao;

import org.springframework.stereotype.Repository;

/**
 * @ClassName DemoMapper
 * @Author Ray
 * @Date 2021/1/26 14:42
 * @Description
 */
@Repository
public interface DemoMapper {

    /**
     * 新建
     * @return
     */
   Integer insert();
}
