package com.sz.projectManagement;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Web程序启动类
 *
 * @author lipan
 * @date 2022-01-11 15:09:18
 */
public class SzProjectManagementServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SzProjectManagementApplication.class);
    }

}
