package com.example.collection_box.entity;

import java.math.BigDecimal;

public class Event {
    private String name;
    private BigDecimal amount;
    private String currency;

    public Event(String name, String currency){
        this.amount = BigDecimal.ZERO;
        this.name = name;
        this.currency = currency;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public void addAmount(BigDecimal money){
        this.amount = getAmount().add(money);
    }
}
