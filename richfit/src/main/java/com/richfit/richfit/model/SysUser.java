package com.richfit.richfit.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName SysUser
 * @Description:
 * @Author BruthLi
 * @Date 2019/11/9
 * @Version V1.0
 **/
@Data
@Entity
@Table(name = "LJ")
public class SysUser implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "USERID")
    private String userId;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "SEX")
    private String sex;
}
