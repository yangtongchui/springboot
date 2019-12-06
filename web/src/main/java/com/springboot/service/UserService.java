package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.mapper.UserMapper;

@Service
public class UserService {
	
    @Autowired
    UserMapper userMapper;
    
    public User getById(int id){
        return userMapper.getById(id);
    }
    
    public void saveUser(User user){
    	userMapper.saveUser(user);
    }
    
    public void delUser(int id){
    	userMapper.delUser(id);
    }
    
}
