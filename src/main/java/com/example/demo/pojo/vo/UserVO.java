package com.example.demo.pojo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "UserVO", description = "用户值对象") // 文档注解， 当请求参数为对象使用
public class UserVO {

    @ApiModelProperty(name = "userId", value = "用户ID")
    private String userId;

    @ApiModelProperty(name = "userName", value = "用户名")
    private String userName;

    @ApiModelProperty(name = "userAge", value = "用户年龄")
    private Integer userAge;

    @ApiModelProperty(name = "userPhone", value = "用户号码")
    private String userPhone;
}