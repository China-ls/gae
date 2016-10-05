package com.ls.wechat.websocket;

import org.springframework.web.socket.WebSocketHandler;

public interface WebSocketMessageHandler extends WebSocketHandler {
    void broadcaseMessage(String message);
}
