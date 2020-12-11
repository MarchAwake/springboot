package com.example.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Hello", description = "Hello")
public class Hello {

    @ApiModelProperty(name = "name", value = "姓名", required = true)
    private String name;

    @ApiModelProperty(name = "age", value = "年龄", required = true)
    private Integer age;

    @ApiModelProperty(name = "responseCode", value = "响应代码", hidden = true)
    private Integer responseCode;
}
