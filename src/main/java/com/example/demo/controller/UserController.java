package com.example.demo.controller;

import com.example.demo.pojo.model.User;
import com.example.demo.pojo.vo.UserVO;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 接口文档地址 127.0.0.1：9000/doc.html

@RestController
@RequestMapping("user")
@Api(value = "UserController", tags = "用户相关接口API")  //文档注解，作用域类
public class UserController {

    // 自动new对象， 注入
    @Autowired
    private UserService userService;

    @GetMapping("list")  // 启动访问路径 127.0.0.1：9000/user/list
    @ApiOperation(value = "用户列表接口", notes = "用户列表接口")  // 文档注解，作用域方法
    public List<User> userList() {

        return userService.userList();
    }

    @GetMapping  // 启动访问路径 127.0.0.1：9000/user/list
    @ApiOperation(value = "用户详情接口", notes = "用户详情接口")  // 文档注解，作用域方法
    public User detail(
            @ApiParam(name = "userId", value = "用户iD") // 文档注解，作用域参数
            @RequestParam(name = "userId") String userId) {

        return userService.detail(userId);
    }

    @PostMapping  // 启动访问路径 127.0.0.1：9000/user/list
    @ApiOperation(value = "用户保存接口", notes = "用户保存接口")  // 文档注解，作用域方法
    public User save(@RequestBody UserVO uservo) {

        User user = new User();
        user.setId(uservo.getUserId());
        user.setUserName(uservo.getUserName());
        user.setUserAge(uservo.getUserAge());
        user.setUserPhone(uservo.getUserPhone());

        return userService.save(user);
    }

    @DeleteMapping  // 启动访问路径 127.0.0.1：9000/user/list
    @ApiOperation(value = "用户删除接口", notes = "用户删除接口")  // 文档注解，作用域方法
    public Boolean delete(@ApiParam(name = "userId", value = "用户iD") // 文档注解，作用域参数
                       @RequestParam(name = "userId") String userId ) {

        return userService.delete(userId);
    }
}
