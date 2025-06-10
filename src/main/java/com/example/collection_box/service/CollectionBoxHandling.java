package com.example.collection_box.service;

import com.example.collection_box.entity.CollectionBox;
import com.example.collection_box.entity.Event;

public interface CollectionBoxHandling {
    CollectionBox createBox();
    void addMoney(Long boxID, int amount, String currency);
    void assignToEvent(Long boxID, Event event);
    void empty();
}
