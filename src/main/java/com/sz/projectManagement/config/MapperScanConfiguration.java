package com.sz.projectManagement.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置mapper包扫描
 *
 * @author lipan
 * @date 2022-01-11 15:09:18
 */
@Configuration
@MapperScan(basePackages = {"cn.stylefeng.**.mapper", "com.sz.projectManagement.**.mapper"})
public class MapperScanConfiguration {

}
