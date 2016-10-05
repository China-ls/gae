package com.ls.wechat.service;

import com.ls.wechat.core.service.BasicService;
import com.ls.wechat.entity.wx.WechatToken;

public interface WechatTokenService extends BasicService<WechatToken, Integer> {

    WechatToken initWechatTokenWithCache();

    WechatToken initWechatToken();

    WechatToken getWechatToken();

}
