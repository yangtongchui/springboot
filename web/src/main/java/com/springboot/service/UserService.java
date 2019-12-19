package com.springboot.service;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.springboot.entity.User;
import com.springboot.mapper.UserMapper;

@Service
public class UserService {
	
    @Autowired
    UserMapper userMapper;
    @Autowired
    private RestTemplate restTemplate;
    
    public User getById(String id){
        return userMapper.getById(id);
    }
    
    public void saveUser(User user){
    	userMapper.saveUser(user);
    }
    
    public void delUser(String id){
    	userMapper.delUser(id);
    }
    
    public String getUserRest(Map<String, Object> params){
    	String url = "http://localhost:8080/front/member/getUser";
    	JSONObject json = new JSONObject(params);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Object> stringHttpEntity = new HttpEntity<>(json, headers);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, stringHttpEntity, String.class);
        return stringResponseEntity.getBody();
    }
    
}
