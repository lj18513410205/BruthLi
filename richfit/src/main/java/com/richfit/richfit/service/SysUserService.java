package com.richfit.richfit.service;

import com.richfit.richfit.model.SysUser;

import java.util.List;

public interface SysUserService {

    List<SysUser> listSys();

    void deleteListSys(String id) throws Exception;

    SysUser saveListSys(SysUser sysUser);
}
