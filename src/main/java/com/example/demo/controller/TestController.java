package com.example.demo.controller;

import com.example.demo.pojo.Hello;
import com.example.demo.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("project")
@Api(value = "TestController", tags = "测试相关接口API")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("sayHello") // 定义GET访问方式
    @ApiOperation(value = "问好接口", notes = "问好接口", httpMethod = "GET")
    public String sayHello(
            @ApiParam(name = "name", value = "名字")
            @RequestParam(name = "name") String name) {

        return testService.sayHello(name);
    }

    @PostMapping("sayHello") // 定义GET访问方式
    @ApiOperation(value = "问好接口", notes = "问好接口", httpMethod = "POST")
    public Hello sayHello(@RequestBody Hello hello) {

        return testService.sayHello(hello);
    }
}
