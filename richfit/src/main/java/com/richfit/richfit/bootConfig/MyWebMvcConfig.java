package com.richfit.richfit.bootConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyWebMvcConfig
 * @Description:
 * @Author BruthLi
 * @Date 2020/1/16
 * @Version V1.0
 **/
@Configuration
public class MyWebMvcConfig  implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/templates/*.html");
    }
}
