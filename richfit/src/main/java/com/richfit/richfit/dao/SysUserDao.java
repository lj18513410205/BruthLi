package com.richfit.richfit.dao;

import com.richfit.richfit.model.SysUser;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//账号：user  密码：控制台打印
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
public interface SysUserDao extends CrudRepository<SysUser, String> {
}
