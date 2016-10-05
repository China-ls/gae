package com.ls.wechat.service.impl;

import com.ls.wechat.consts.WeixinAPIConst;
import com.ls.wechat.core.repositories.BasicRepository;
import com.ls.wechat.core.service.BasicServiceImpl;
import com.ls.wechat.entity.wx.WechatToken;
import com.ls.wechat.repositories.WechatTokenRepository;
import com.ls.wechat.service.WechatTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

@Service
public class WechatTokenServiceImpl extends BasicServiceImpl<WechatToken, Integer> implements WechatTokenService {

    private static Logger log = LoggerFactory.getLogger(WechatTokenServiceImpl.class);

    @Autowired
    private WechatTokenRepository wechatTokenRepository;
    @Autowired
    private WeixinAPIConst weixinAPIConst;

    private WechatToken cachedWechatToken;

    @Override
    public BasicRepository<WechatToken, Integer> getRepository() {
        return wechatTokenRepository;
    }

    @Override
    public WechatToken initWechatTokenWithCache() {
        if (log.isDebugEnabled()) {
            log.debug("init wechat token with cache");
        }
        WechatToken wechatToken = wechatTokenRepository.findByAppid(weixinAPIConst.getAppid());
        if (isTokenExpired(wechatToken)) {
            wechatToken = initWechatToken();
        }
        return wechatToken;
    }

    @Override
    public WechatToken initWechatToken() {
        if (log.isDebugEnabled()) {
            log.debug("begain init wechat token");
        }
//        wechatTokenRepository.deleteAll();
        long currentTime = System.currentTimeMillis();
        Token token = TokenAPI.token(weixinAPIConst.getAppid(), weixinAPIConst.getSecret());
        currentTime += token.getExpires_in() * 1000;

        WechatToken wechatToken = new WechatToken();
        wechatToken.setId(1);
        wechatToken.setAccess_token(token.getAccess_token());
        wechatToken.setAppid(weixinAPIConst.getAppid());
        wechatToken.setSecret(weixinAPIConst.getSecret());
        wechatToken.setToken(weixinAPIConst.getToken());
        wechatToken.setExpiresTime(currentTime);

        cachedWechatToken = save(wechatToken);
        if (log.isDebugEnabled()) {
            log.debug("finish init wechat token [{}]", cachedWechatToken);
        }
        return cachedWechatToken.cloneSelf();
    }

    @Override
    public WechatToken getWechatToken() {
        if (isTokenExpired(cachedWechatToken)) {
            if (log.isDebugEnabled()) {
                log.debug("get wechat token with create");
            }
            return initWechatToken();
        }
        if (log.isDebugEnabled()) {
            log.debug("get wechat token from cache [{}]", cachedWechatToken);
        }
        return cachedWechatToken.cloneSelf();
    }

    private boolean isTokenExpired(WechatToken wechatToken) {
        return null == wechatToken
                || null == wechatToken.getExpiresTime()
                || wechatToken.getExpiresTime() <= System.currentTimeMillis();
    }

}
