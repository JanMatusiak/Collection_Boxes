package com.example.collection_box.service;

import com.example.collection_box.entity.Event;

import java.util.List;

public interface EventService {
    Event createEvent(String name, String currency);
    List<Event> eventList();
    Event getEventByID(Long ID);
}
