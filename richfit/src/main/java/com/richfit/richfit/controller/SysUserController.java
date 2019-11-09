package com.richfit.richfit.controller;

import com.richfit.richfit.model.SysUser;
import com.richfit.richfit.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.persistence.Query;
import java.util.List;

/**
 * @ClassName SysUserController
 * @Description:
 * @Author BruthLi
 * @Date 2019/11/9
 * @Version V1.0
 **/
@RestController
@RequestMapping(value = "/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;




    @GetMapping(value = "",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUser> listSys(){
        return sysUserService.listSys();
    }


}
