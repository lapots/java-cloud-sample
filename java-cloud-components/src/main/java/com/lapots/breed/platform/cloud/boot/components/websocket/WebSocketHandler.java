package com.lapots.breed.platform.cloud.boot.components.websocket;

import com.lapots.breed.platform.cloud.boot.devtools.JavaLogUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private static final Logger LOGGER = JavaLogUtils.getLogger();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        LOGGER.info(" Server >>>> {}", message);
        session.sendMessage(message);
    }
}
