package com.example.collection_box.service;

import com.example.collection_box.entity.Event;
import com.example.collection_box.repository.CollectionBoxRepository;
import com.example.collection_box.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImplementation implements EventService {

    private final EventRepository eventRepo;

    public EventServiceImplementation(EventRepository eventRepo){
        this.eventRepo = eventRepo;
    }

    public Event createEvent(String name, String currency){
        return eventRepo.save(new Event(name, currency));
    }

    public List<Event> eventList(){
        return eventRepo.findAll();
    }
    public Event getEventByID(Long ID){
        return eventRepo.findById(ID).
                orElseThrow(() -> new RuntimeException("No such event: " + ID));
    }
}
