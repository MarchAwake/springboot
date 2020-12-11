package com.example.demo.service;

import com.example.demo.pojo.Hello;

/**
 * <h1>测试服务接口定义</h1>
 */
public interface TestService {

    /**
     * <h2>方法定义</h2>
     * @param name
     * @return
     */
    String sayHello(String name);


    Hello sayHello(Hello hello);
}
