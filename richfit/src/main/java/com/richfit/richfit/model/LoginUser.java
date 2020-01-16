package com.richfit.richfit.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName LoginUser
 * @Description: 登录
 * @Author BruthLi
 * @Date 2020/1/16
 * @Version V1.0
 **/
@Entity
@Data
@Table(name = "LJ1")
public class LoginUser implements Serializable {
    @Id
    @Column(name = "ID1")
    private String uId;

    @Column(name = "PWORD1")
    private String pWord;

    @Column(name = "NAME1")
    private String uName;

}
