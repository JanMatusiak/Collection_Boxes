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

    protected CollectionBox(){
        this.empty = true;
        this.amount = BigDecimal.ZERO;
    }

    public Long getID(){
        return id;
    }

    public Event getEvent(){
        return event;
    }

    public boolean isEmpty(){
        return empty;
    }
    public BigDecimal getAmount(){
        return amount;
    }
}
