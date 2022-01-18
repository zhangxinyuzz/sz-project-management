package com.sz.projectManagement;

import cn.stylefeng.roses.kernel.db.starter.GunsDataSourceAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;

/**
 * SpringBoot方式启动类
 *
 * @author lipan
 * @date 2022-01-11 15:09:18
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"cn.stylefeng", "com.sz.projectManagement"}, exclude = {FlywayAutoConfiguration.class, GunsDataSourceAutoConfiguration.class})
public class SzProjectManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SzProjectManagementApplication.class, args);
        log.info(SzProjectManagementApplication.class.getSimpleName() + " is success!");
    }

}

