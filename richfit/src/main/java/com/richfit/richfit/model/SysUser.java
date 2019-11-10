package com.richfit.richfit.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
