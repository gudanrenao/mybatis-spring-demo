package com.zhangwenit.mybatis.spring.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description <mybatis:scan/>的java配置模式
 * @Author ZWen
 * @Date 2019/4/22 4:35 PM
 * @Version 1.0
 **/
@Configuration
@MapperScan({"com.zhangwenit.mybatis.spring.demo.mapper"})
public class MapperScanConfiguration {
}