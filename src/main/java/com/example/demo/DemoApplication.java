package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@SpringBootApplication
@MapperScan(basePackages = {"com.example.demo.dao"})
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        ConfigurableEnvironment env = app.run(args).getEnvironment();

        log.info("HelloApplication 启动成功：\thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
