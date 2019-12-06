package com.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户对象",description = "这是用户对象 ")
public class User {
	
	@ApiModelProperty(value = "主键", name = "id",example = "1",required = true)
    private Integer id;
    @ApiModelProperty(value = "用户名", name = "username",example = "张三",required = true)
    private String name;
    @ApiModelProperty(value = "年龄", name = "age",example = "1",required = true)
    private String age;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

}
