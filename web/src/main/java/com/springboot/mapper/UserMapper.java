package com.springboot.mapper;

import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import com.springboot.entity.User;

@Repository
public interface UserMapper {
	
    User getById(String id);
    
    void saveUser(User user);
    
    @Delete("delete from user where id = #{id}")
    void delUser(String id);
}
