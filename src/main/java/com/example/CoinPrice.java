package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CoinPrice {
    @JsonProperty("e")
    private String eventType;
 
    @JsonProperty("E")
    private long eventTime;
 
    @JsonProperty("s")
    private String symbol;
 
    @JsonProperty("t")
    private String tradeId;
 
    @JsonProperty("p")
    private BigDecimal price;
 
    @JsonProperty("q")
    private BigDecimal quantity;
 
    @JsonProperty("b")
    private long buyerOrderId;
 
    @JsonProperty("a")
    private long sellerOrderId;
 
    @JsonProperty("T")
    private long tradeTime;
 
    @JsonProperty("m")
    private boolean marketMaker;
 
    @JsonProperty("M")
    private boolean ignore;

}