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
    private boolean assigned;
    private BigDecimal amount;

    public CollectionBox(){
        this.empty = true;
        this.assigned = false;
        this.amount = BigDecimal.ZERO;
    }

    public void addAmount(BigDecimal money){
        setAmount(getAmount().add(money));
        empty = getAmount().equals(BigDecimal.ZERO);
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

    public boolean isAssigned(){
        return assigned;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public void setAmount(BigDecimal money){
        this.amount = money;
    }

    public void assignTo(Event event) {
        if (this.assigned) {
            throw new IllegalStateException("Box already assigned");
        }
        this.event = event;
        this.assigned = true;
    }
}
