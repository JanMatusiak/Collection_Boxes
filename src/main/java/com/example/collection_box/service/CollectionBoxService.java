package com.example.collection_box.service;

import com.example.collection_box.entity.CollectionBox;

import java.math.BigDecimal;
import java.util.List;

public interface CollectionBoxService {
    CollectionBox createBox();
    List<CollectionBox> listBoxes(boolean onlyEmpty);
    CollectionBox addMoney(Long boxID, BigDecimal amount, String currency);
    CollectionBox assignToEvent(Long boxID, Long eventID);
    void empty(Long boxID);
}
