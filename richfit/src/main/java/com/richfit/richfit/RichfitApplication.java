package com.richfit.richfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@ServletComponentScan
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class RichfitApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RichfitApplication.class, args);
    }

    /**
     * 配置跨域访问的过滤器
     * @return
     */
    /*@Bean
    public FilterRegistrationBean registerFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*");
        bean.setFilter(new CrosFilter());
        return bean;
    }*/
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RichfitApplication.class);
    }
}
