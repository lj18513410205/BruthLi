package com.richfit.richfit.bootConfig;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName SecurityConfiguration
 * @Description: spring security
 * @Author BruthLi
 * @Date 2020/1/11
 * @Version V1.0
 **/
//@Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。
//@Configuration 这个其实没必要加，因为@EnableWebSecurity注解中已经有了
@EnableWebSecurity //EnableWebSecurity注解有两个作用,1: 加载了WebSecurityConfiguration配置类, 配置安全认证策略。2: 加载了AuthenticationConfiguration, 配置了认证信息
@EnableGlobalMethodSecurity(prePostEnabled = true)//来判断用户对某个控制层的方法是否具有访问权限
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     *  webSecurity.ignoring().antMatchers("/sys/user/jk");
     *  作用是访问/sys/user/jk接口和其他查询接口可以与数据库交互(访问)，除查询接口外(不添加数据或删除数据)其他非查询接口访问一律403
     * @param webSecurity
     * @throws Exception
     */
   /*@Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/sys/user/saveListSys");
    };*/

    /**
     * permitAll():其实这种写法和ignoring上面功能是一样允许/sys/user/jk，其他403
     * @param http
     * @throws Exception
     */
   @Override
    public void configure(HttpSecurity http) throws Exception {
       //csrf导致403 http.csrf().disable();解除删除，修改，新增403
      /* http.authorizeRequests()
                .antMatchers("/**").permitAll()
               // anyRequest().authenticated()就会要求所有进入应用的 HTTP请求都要进行认证 .anyRequest().authenticated();

    }*/
    //  http.authorizeRequests().
       http.csrf().disable()
               .authorizeRequests()
            //  antMatchers("/sys/user/saveListSys","/sys/user/jk").permitAll().
              .antMatchers("/sys/user/deleteListSys/{id}").access("hasRole('ROLE_ADMIN')")
              .anyRequest().authenticated()
              .and().formLogin().loginPage("/templates/testLogin.html")
              .usernameParameter("lj")
              .passwordParameter("lj")
              .and()
              .logout().logoutUrl("/templates/testLogout.html");
   }

   /* @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/

    /**  把swagger-ui.html,/sys/user/saveListSys,/sys/user/jk放开，不然访问时403
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/userjwt","/v2/api-docs", "/swagger-resources/configuration/ui",
                "/swagger-resources","/swagger-resources/configuration/security",
                "/swagger-ui.html","/css/**", "/js/**","/images/**", "/webjars/**", "**/favicon.ico", "/index")
                .antMatchers("/sys/user/saveListSys","/sys/user/jk","/sys/login");

    }
}