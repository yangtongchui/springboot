package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "首页接口",tags = {"首页相关业务的controller"})
public class IndexController {
	
	@ApiOperation(value = "异常",notes = "异常测试")
	@GetMapping("/index0")
    public String index0(){
    	int i = 1/0;
        return "index/index";
    }
	@ApiOperation(value = "首页",notes = "首页测试")
	@GetMapping("/index")
    public String index(){
        return "index/index";
    }
    
}
