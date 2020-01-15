package com.richfit.richfit.service;


import com.richfit.richfit.dao.SysUserDao;
import com.richfit.richfit.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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


    @Autowired
    private JdbcTemplate jdbcTemplate;




    @Override
    public List<SysUser> listSys() {
        return sysUserDao.findAll();
    }




    /*@Override
    public List<SysUser> listSys() {
        Query select_u_from_sysUser_u = entityManager.createQuery("select u from SysUser u");
        List<SysUser> resultList = select_u_from_sysUser_u.getResultList();
        System.out.println(resultList);
        return resultList;
    }
*/
    @Override
    @Transactional
    public void deleteListSys(String id) throws Exception{
      //  Query query = entityManager.createQuery("delete from SysUser s where s.userId = :id ");
       /* String hql = "select u from SysUser u where u.userId=:"+id;
        Object singleResult = entityManager.createQuery(hql).getSingleResult();*/
        Optional<SysUser> byId = sysUserDao.findById(id);
        if (! byId.isPresent()){
            throw new Exception();
        };
        entityManager.remove(byId.get());
        entityManager.flush();
    }

    @Override
    @Transactional
    public SysUser saveListSys(SysUser sysUser) {
        SysUser sysUser2 = sysUserDao.saveAndFlush(sysUser);
        return sysUser2;
    }


}
