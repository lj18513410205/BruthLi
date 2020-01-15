package com.richfit.richfit.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName SysUser
 * @Description:
 * @Author BruthLi
 * @Date 2019/11/9
 * @Version V1.0
 **/
@Entity
@Data
@Table(name = "SYS_USER")
public class SysUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "XSX")
    @GenericGenerator(name = "XSX",strategy = "uuid")
   // @SequenceGenerator(name = "XSX",sequenceName = "HALLOWEEN")
    @Column(name = "USERID")
    private String userId;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "USERNAME")
    private String userName;




}
