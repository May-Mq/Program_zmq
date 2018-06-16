package com.mqz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mqz.dao")
public class ZmqProApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZmqProApplication.class, args);
	}
}
