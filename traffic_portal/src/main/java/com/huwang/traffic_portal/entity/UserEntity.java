package com.huwang.traffic_portal.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_user")
public class UserEntity {

    private int id;
    private String account;
    private String passwd;
    private String desc;
    private String token;
    private Date lastLoginTime;

    @Column(name="token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name="login_time")
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    @Column(name="passwd")
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getDesc() {
        return desc;
    }

    @Column(name="desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
