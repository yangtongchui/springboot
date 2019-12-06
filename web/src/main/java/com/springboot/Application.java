package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@MapperScan("com.springboot.mapper")
@SpringBootApplication
@ServletComponentScan
public class Application extends SpringBootServletInitializer{
	
    public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
    }
    
    /*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder  application) {
	   return application.sources(Application.class);
	}*/
	

}
