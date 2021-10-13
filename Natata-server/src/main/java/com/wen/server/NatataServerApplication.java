package com.wen.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wen
 */
@SpringBootApplication
@MapperScan("com.wen.server.mapper")
public class NatataServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NatataServerApplication.class, args);
    }

}
