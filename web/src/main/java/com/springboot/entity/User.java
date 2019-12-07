package com.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//@ApiModel(value = "用户对象",description = "这是用户对象 ")
@Data
@Document(indexName = "majiaxueyuan",type = "user")
public class User {
	
	//@ApiModelProperty(value = "主键", name = "id",example = "1",required = true)
	@Id
    private String id;
    //@ApiModelProperty(value = "用户名", name = "username",example = "张三",required = true)
	@Field(type = FieldType.text, analyzer = "name",searchAnalyzer = "name", fielddata=true)
    private String name;
    //@ApiModelProperty(value = "年龄", name = "age",example = "1",required = true)
	@Field(type = FieldType.text, analyzer = "age",searchAnalyzer = "age", fielddata=true)
    private String age;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
