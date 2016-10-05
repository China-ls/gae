package com.ls.wechat.consts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeixinAPIConst {
    @Value("#{wx.appid}")
    private String appid;
    @Value("#{wx.secret}")
    private String secret;
    @Value("#{wx.token}")
    private String token;

    public String getAppid() {
        return appid;
    }

    public String getSecret() {
        return secret;
    }

    public String getToken() {
        return token;
    }
}
