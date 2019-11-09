package com.richfit.richfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

//exclude = MongoAutoConfiguration.class  springboot自动配置了支持mongodb。在启动springboot时会自动实例化一个mongo实例，需要禁用自动配置 ，增加@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class RichfitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RichfitApplication.class, args);
    }

}
