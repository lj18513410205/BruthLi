package com.richfit.richfit.service;




import com.richfit.richfit.Dto.SysUserDto;
import com.richfit.richfit.dao.SysUserDao;
import com.richfit.richfit.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import com.alibaba.fastjson.JSON;
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


    /**
     * 从List<A> copy到List<B>
     * @param list
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> List<T> copy(List<?> list,Class<T> clazz){
        String oldOb = JSON.toJSONString(list);
        return JSON.parseArray(oldOb, clazz);
    }


    @Override
    public List<SysUser> listSys() {
        //List<SysUser> list = new ArrayList<>(3);
        String sql = "select u.* from LJ u";
        //这种只支持 String.class   Integer.class 不支持SysUser.class;
        //List<SysUser> select_u_from_sysUser_u_ = jdbcTemplate.queryForList("select u.* from LJ u ", SysUser.class);
        //下面这种没问题
        //List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        List<SysUserDto> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper(SysUserDto.class));
        List<SysUser> copy = SysUserServiceImpl.copy(query, SysUser.class);
        return copy;
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
    public void deleteListSys(String id) {
      //  Query query = entityManager.createQuery("delete from SysUser s where s.userId = :id ");
        SysUser singleResult = (SysUser)entityManager.createQuery("select u from SysUser u where u.userI=:id").getSingleResult();
        entityManager.remove(singleResult);
    }

}
