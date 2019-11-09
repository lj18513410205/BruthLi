package com.richfit.richfit.service;


import com.richfit.richfit.dao.SysUserDao;
import com.richfit.richfit.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Description:
 * @Author BruthLi
 * @Date 2019/11/9
 * @Version V1.0
 **/
@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserDao sysUserDao;

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<SysUser> listSys() {
        Query select_u_from_sysUser_u = entityManager.createQuery("select u from SysUser u");
        List<SysUser> resultList = select_u_from_sysUser_u.getResultList();
        System.out.println(resultList);
        return resultList;
    }

}
