package com.example.collection_box.service;

import com.example.collection_box.entity.Event;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface EventService {
    Event createEvent(String name, String currency);
    List<Event> eventList();
    Event getEventByID(Long ID);
}
