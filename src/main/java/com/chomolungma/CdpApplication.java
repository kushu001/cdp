package com.chomolungma;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chomolungma.*.mapper")
public class CdpApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdpApplication.class, args);
	}

}
