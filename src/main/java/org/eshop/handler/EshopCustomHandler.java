package org.eshop.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * Created by ltaoj on 2017/9/20.
 * 客服消息处理
 */
public class EshopCustomHandler extends AbstractWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(EshopCustomHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("Received message:" + message.getPayload());
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("Hello World!"));
    }
}
