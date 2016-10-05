package com.ls.wechat.controller;

import com.ls.wechat.consts.WeixinAPIConst;
import com.ls.wechat.util.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import weixin.popular.bean.message.EventMessage;
import weixin.popular.bean.xmlmessage.XMLMessage;
import weixin.popular.bean.xmlmessage.XMLTextMessage;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class WxMessageController {
    private static Logger log = LoggerFactory.getLogger(WxMessageController.class);

    @Autowired
    private WeixinAPIConst wexinAPIConst;

    @RequestMapping("/wechat/message")
    public void wechatMessage(
            @ModelAttribute String signature,
            @ModelAttribute String timestamp,
            @ModelAttribute String nonce,
            @ModelAttribute String echostr,
            HttpServletRequest request, HttpServletResponse response
    ) {
        try {
            ServletInputStream inputStream = request.getInputStream();
            ServletOutputStream outputStream = response.getOutputStream();

            //首次请求申请验证,返回echostr
            if (echostr != null) {
                StreamUtils.writeToStream(outputStream, echostr);
                return;
            }

            //验证请求签名
            if (!signature.equals(SignatureUtil.generateEventMessageSignature(wexinAPIConst.getToken(), timestamp, nonce))) {
                if (log.isDebugEnabled()) {
                    log.debug("wechat message signature is invalid [signature:{}, timestamp:{}, nonce:{}, echostr:{}].", signature, timestamp, nonce, echostr);
                }
                return;
            }

            if (inputStream != null) {
                //转换XML
                EventMessage eventMessage = XMLConverUtil.convertToObject(EventMessage.class, inputStream);
                String key = eventMessage.getFromUserName() + "__"
                        + eventMessage.getToUserName() + "__"
                        + eventMessage.getMsgId() + "__"
                        + eventMessage.getCreateTime();
//                if (expireKey.exists(key)) {
//                    //重复通知不作处理
//                    return;
//                } else {
//                    expireKey.add(key);
//                }


                //创建回复
                XMLMessage xmlTextMessage = new XMLTextMessage(
                        eventMessage.getFromUserName(),
                        eventMessage.getToUserName(),
                        "你好,你发的消息是：" + eventMessage.getContent());
                //回复
                xmlTextMessage.outputStreamWrite(outputStream);
                return;
            }
            StreamUtils.writeToStream(outputStream, "");
        } catch (IOException e) {
            if (log.isDebugEnabled()) {
                log.debug("recieve wechat message with error.", e);
            }
        }
    }

}
