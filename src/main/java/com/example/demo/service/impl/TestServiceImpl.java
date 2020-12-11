package com.example.demo.service.impl;

import com.example.demo.pojo.Hello;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {


    @Override
    public String sayHello(String name) {

        return "hello" + name;
    }

    @Override
    public Hello sayHello(Hello hello) {

        hello.setResponseCode(200);
        return hello;
    }
}
