package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@ClientEndpoint
public class BinancePriceEndpoint {

    private final ObjectMapper mapper = new ObjectMapper();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");

    @OnMessage
    public void onMessage(String msg) {

        try {
            CoinPrice price = mapper.readValue(msg, CoinPrice.class);

            Date date = new Date(price.getEventTime());

            log.info("Symbol: " + price.getSymbol() + ", Event Time: " + dateFormat.format(date) + " Price: " + price.getPrice());

        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        log.info("Closed because: " + reason.getReasonPhrase());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("Error because: " + error.getMessage());
    }
}