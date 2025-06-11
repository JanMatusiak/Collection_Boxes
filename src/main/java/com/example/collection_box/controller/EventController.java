package com.example.collection_box.controller;

import com.example.collection_box.entity.Event;
import com.example.collection_box.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestParam("name") String name,
                                             @RequestParam("currency") String currency){
        Event event = eventService.createEvent(name, currency);
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }

    @GetMapping
    public ResponseEntity<List<Event>> eventList(){
        List<Event> events = eventService.eventList();
        return ResponseEntity.ok(events);
    }

    @PostMapping("/{eventId}")
    public ResponseEntity<Event> getEventByID(@PathVariable("eventId") Long eventID){
        Event event = eventService.getEventByID(eventID);
        return ResponseEntity.ok(event);
    }
}
