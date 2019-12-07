package com.springboot.dao;

import com.springboot.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends ElasticsearchRepository<User,String> {
}
