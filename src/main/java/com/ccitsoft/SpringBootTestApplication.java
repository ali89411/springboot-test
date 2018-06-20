package com.ccitsoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 启动扫描mapper包
@MapperScan("com.ccitsoft.mapper")
public class SpringBootTestApplication {
	public static void main(String[] args) {
		//
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
}
