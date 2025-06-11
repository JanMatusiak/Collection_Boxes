package com.example.collection_box.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    private BigDecimal amount;
    private final String currency;

    protected Event() {
        this.amount = BigDecimal.ZERO;
        this.currency = null;  // will be set when Spring populates fields
    }

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

    public Long getId(){
        return id;
    }

}
