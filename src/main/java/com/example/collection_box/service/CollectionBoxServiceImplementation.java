package com.example.collection_box.service;

import com.example.collection_box.entity.CollectionBox;
import com.example.collection_box.entity.Event;
import com.example.collection_box.repository.CollectionBoxRepository;
import com.example.collection_box.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CollectionBoxServiceImplementation implements CollectionBoxService {

    private final CollectionBoxRepository boxRepo;
    private final EventRepository eventRepo;

    public CollectionBoxServiceImplementation(CollectionBoxRepository boxRepo, EventRepository eventRepo){
        this.boxRepo = boxRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public CollectionBox createBox(){
        return boxRepo.save(new CollectionBox());
    }

    @Override
    public List<CollectionBox> listBoxes(boolean onlyEmpty) {
        if(onlyEmpty){
            return boxRepo.findByEmpty(true);
        }
        return boxRepo.findAll();
    }

    @Override
    @Transactional
    public CollectionBox addMoney(Long boxID, BigDecimal amount, String currency){
        CollectionBox box = boxRepo.findById(boxID)
                .orElseThrow(() -> new RuntimeException("No such box: " + boxID));
        if(box.isEmpty()){
            throw new IllegalStateException("Box is unassigned");
        } // Here fetch conversions from the internet
        BigDecimal rate = BigDecimal.ONE;
        BigDecimal converted = amount.multiply(rate);
        box.addAmount(converted);
        Event event = box.getEvent();
        event.addAmount(converted);
        eventRepo.save(event);
        return boxRepo.save(box);
    }

    @Override
    public CollectionBox assignToEvent(Long boxID, Event event){
        CollectionBox box = boxRepo.findById(boxID)
                .orElseThrow(() -> new RuntimeException("No such box: " + boxID));
        if(box.isAssigned()){
            throw new IllegalStateException("Box is already assigned");
        }
        box.assign(event);
        return boxRepo.save(box);
    }

    @Override
    public void empty(Long boxID){
        CollectionBox box = boxRepo.findById(boxID)
                .orElseThrow(() -> new RuntimeException("No such box: " + boxID));
        if(!box.isAssigned()){
            box.setAmount(BigDecimal.ZERO);
        } else {
            Event event = box.getEvent();
            event.addAmount(box.getAmount());
            box.setAmount(BigDecimal.ZERO);
            eventRepo.save(event);
            boxRepo.save(box);
        }
    }
}