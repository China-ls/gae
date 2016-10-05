package com.ls.wechat.init;

import com.ls.wechat.entity.wx.WechatToken;
import com.ls.wechat.service.WechatTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class InitWechatToken implements InitializingBean {
    private static Logger log = LoggerFactory.getLogger(InitWechatToken.class);


    @Autowired
    private WechatTokenService wechatTokenService;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("begain init wechat token");
        }

        WechatToken token = wechatTokenService.initWechatTokenWithCache();

        log.debug("token: {}", token);

        if (log.isDebugEnabled()) {
            log.debug("finish init wechat token");
        }
    }
}
