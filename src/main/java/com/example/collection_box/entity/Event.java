package com.example.collection_box.entity;

import java.math.BigDecimal;

public class Event {
    private final String name;
    private BigDecimal amount;
    private final String currency;

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

    public String getName(){
        return name;
    }

    public String getCurrency(){
        return currency;
    }

}
