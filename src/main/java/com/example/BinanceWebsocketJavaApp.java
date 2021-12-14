package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.net.URI;

@SpringBootApplication
public class BinanceWebsocketJavaApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BinanceWebsocketJavaApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.connectToServer(BinancePriceEndpoint.class, new URI("wss://stream.binance.com:9443/ws/btcbusd@trade"));
    }
}
