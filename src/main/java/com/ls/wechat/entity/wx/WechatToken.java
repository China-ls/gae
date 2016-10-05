package com.ls.wechat.entity.wx;

import com.ls.wechat.entity.BasicEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "wx_token")
public class WechatToken extends BasicEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "appid")
    private String appid;
    @Column(name = "secret")
    private String secret;
    @Column(name = "token")
    private String token;
    @Column(name = "access_token")
    private String access_token;
    @Column(name = "expires_time")
    private Long expiresTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(Long expiresTime) {
        this.expiresTime = expiresTime;
    }

    public WechatToken cloneSelf() {
        WechatToken wechatToken = new WechatToken();
        wechatToken.setId(id);
        wechatToken.setExpiresTime(expiresTime);
        wechatToken.setSecret(secret);
        wechatToken.setAppid(appid);
        wechatToken.setToken(token);
        wechatToken.setAccess_token(access_token);
        return wechatToken;
    }

    @Override
    public String toString() {
        return "WechatToken{" +
                "id=" + id +
                ", appid='" + appid + '\'' +
                ", secret='" + secret + '\'' +
                ", token='" + token + '\'' +
                ", access_token='" + access_token + '\'' +
                ", expiresTime=" + expiresTime +
                '}';
    }
}
