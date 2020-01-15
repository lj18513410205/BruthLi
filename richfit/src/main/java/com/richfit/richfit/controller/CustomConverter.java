package com.richfit.richfit.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.Converter;
import com.richfit.richfit.model.SysUser;

/**
 * @ClassName CustomConverter
 * @Description:
 * @Author BruthLi
 * @Date 2020/1/7
 * @Version V1.0
 **/
public class CustomConverter implements Converter<SysUser> {
    @Override
    public SysUser convert(Object value, SysUser sysUser ) throws IllegalArgumentException {
        sysUser = new SysUser();
        String[] str = Convert.toStrArray(value);
        sysUser.setUserId(str[0]);
        sysUser.setUserName(str[1]);
        sysUser.setSex(str[2]);
        return sysUser;
    }
}
