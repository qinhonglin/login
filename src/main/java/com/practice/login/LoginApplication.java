package com.practice.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com/practice/login/login/dao")
//这里可以看下这个注解的内部，redisNamespace是可以指定redis里的key值前缀的
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds=30)
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}
}
