package com.example.collection_box.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class CollectionBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private boolean empty;
    private BigDecimal amount;
    private String currency;

    protected CollectionBox(){
        this.empty = true;
        this.amount = BigDecimal.ZERO;
    }

    public CollectionBox(String currency){
        this();
        this.currency = currency;
    }

    public Event getEvent(){
        return event;
    }

    public boolean getStatus(){
        return empty;
    }
    public BigDecimal getAmount(){
        return amount;
    }
    public Long getID(){
        return id;
    }
}
