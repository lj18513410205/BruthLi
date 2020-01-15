package com.richfit.richfit.controller;

import com.richfit.richfit.model.SysUser;
import com.richfit.richfit.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @ClassName SysUserController
 * @Description:
 * @Author BruthLi
 * @Date 2019/11/9
 * @Version V1.0
 **/
@Api(value = "中油练习小demo")
@RestController
@RequestMapping(value = "/sys/user")
public  class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "SysUser查询的方法",notes = "SysUser查询的方法")
    @RequestMapping(value = "/jk",method = RequestMethod.GET)
    @ResponseBody
    public List<SysUser> listSys(){
        List<SysUser> sysUsers = sysUserService.listSys();
        return sysUsers;
    }

    @ApiOperation(value = "SysUser删除的方法",notes = "SysUser删除的方法")
    @RequestMapping(value = "/deleteListSys/{id}",method = RequestMethod.POST)
    public void deleteListSys(@ApiParam(value = "删除所需ID",name = "id",required = true)
                                 @PathVariable("id") String id){
     sysUserService.deleteListSys(id);
    }

    /**
     * 新增和修改
     * @param sysUser
     * @return
     */
    @ApiOperation(value = "SysUser新增的方法",notes = "SysUser新增的方法")
    @RequestMapping(value = "/saveListSys",method = RequestMethod.POST)
    public SysUser saveListSys(@RequestBody SysUser sysUser){
        SysUser sysUser1 = sysUserService.saveListSys(sysUser);
        return sysUser1;
    }



}
