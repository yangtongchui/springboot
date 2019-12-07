package com.springboot.controller;

import com.springboot.dao.UserDao;
import com.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("es")
public class ESController {

    @Autowired
    private UserDao userDao;

    @PostMapping("saveUser")
    public User saveUser(@RequestBody User user){
        return userDao.save(user);
    }

    @PostMapping("getUser")
    public Optional<User> getUser(@RequestBody User user){
        return userDao.findById(user.getId());
    }

    @PostMapping("delUser")
    public void delUser(@RequestBody User user){
         userDao.delete(user);
    }

}
