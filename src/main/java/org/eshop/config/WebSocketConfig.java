package org.eshop.config;

import org.eshop.handler.EshopCustomHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by ltaoj on 2017/9/20.
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(eshopCustomHandler(), "/custom").withSockJS();
    }

    @Bean
    public EshopCustomHandler eshopCustomHandler() {
        return new EshopCustomHandler();
    }
}
