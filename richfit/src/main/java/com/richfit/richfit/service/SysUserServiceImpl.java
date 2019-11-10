package com.richfit.richfit.service;


import com.richfit.richfit.dao.SysUserDao;
import com.richfit.richfit.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

   /* @Override
    public List<SysUser> listSys() {
        List<SysUser> list = new ArrayList<>(3);
        String sql = "select u.* from LJ u";
        //这种只支持 String.class   Integer.class 不支持SysUser.class;
       // List<SysUser> select_u_from_sysUser_u_ = jdbcTemplate.queryForList("select u.* from LJ u ", SysUser.class);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
        maps.stream().forEach(a->{
            SysUser sys = new SysUser();
            sys.setUserId((String) a.get("USERID"));
            sys.setUserName((String) a.get("USERNAME"));
            sys.setSex((String) a.get("SEX"));
            list.add(sys);
        });
        return list;
    }
*/



    @Override
    public List<SysUser> listSys() {
        Query select_u_from_sysUser_u = entityManager.createQuery("select u from SysUser u");
        List<SysUser> resultList = select_u_from_sysUser_u.getResultList();
        System.out.println(resultList);
        return resultList;
    }

    @Override
    public void deleteListSys(String id) {
      //  Query query = entityManager.createQuery("delete from SysUser s where s.userId = :id ");
        SysUser singleResult = (SysUser)entityManager.createQuery("select u from SysUser u where u.userI=:id").getSingleResult();
        entityManager.remove(singleResult);
    }

}
