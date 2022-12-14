package com.chomolungma.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * cdp框架启动类
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.chomolungma"})
@MapperScan("com.chomolungma.**.mapper")
public class CdpApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(CdpApplication.class, args);
    }
}
