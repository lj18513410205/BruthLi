package com.richfit.richfit.service;

import com.richfit.richfit.model.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SysUserService {

    List<SysUser> listSys();
}
