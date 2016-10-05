package com.ls.wechat.repositories;

import com.ls.wechat.core.repositories.BasicRepository;
import com.ls.wechat.entity.wx.WechatToken;
import org.springframework.stereotype.Repository;

@Repository
public interface WechatTokenRepository extends BasicRepository<WechatToken, Integer> {

    WechatToken findByAppid(String appid);

}
