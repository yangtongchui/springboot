package com.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springboot.entity.User;
import com.springboot.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import sun.misc.Request;

import com.alibaba.fastjson.JSONObject;
import com.springboot.Application;

//@Api(value = "用户接口",tags = {"用户相关业务的controller"})
@Controller
public class UserController {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Application.class);
 
    @Autowired
    private UserService userService;
 
    
//    @ApiOperation("查询用户的接口")
	//    @ApiImplicitParams({
//       @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1")
//    })
	@PostMapping("/front/member/getUser")
    @ResponseBody
    public User getUser(@RequestBody User user){
		logger.info("查询用户接收参数："+user);
        return userService.getById(user.getId());
    }
    
    @PostMapping("/front/member/saveUser")
    @ResponseBody
    public String saveUser(@RequestBody User user){
    	 userService.saveUser(user);
    	 return "success";
    }
    
//    @ApiOperation("删除用户的接口")
//    @ApiImplicitParams({
//       @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1")
//    })
    @PostMapping("/front/member/delUser")
    @ResponseBody
    public String delUser(@RequestBody String id){
    	userService.delUser(id);
    	return "success";
    }
    

    @GetMapping("/front/member/getUserRest")
    @ResponseBody
    public String getUserRest(){
    	Map<String, Object> params = new HashMap<>();
    	params.put("id", "123");
		String result = userService.getUserRest(params);
    	return result;
    }
    
}
