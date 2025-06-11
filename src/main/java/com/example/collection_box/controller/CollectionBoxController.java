package com.example.collection_box.controller;

import com.example.collection_box.entity.CollectionBox;
import com.example.collection_box.service.CollectionBoxService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping ("/boxes")
public class CollectionBoxController {
    private final CollectionBoxService boxService;

    public CollectionBoxController(CollectionBoxService boxService){
        this.boxService = boxService;
    }

    @PostMapping
    public ResponseEntity<CollectionBox> createBox(){
        CollectionBox box = boxService.createBox();
        return ResponseEntity.status(HttpStatus.CREATED).body(box);
    }

    @GetMapping
    public ResponseEntity<List<CollectionBox>> listBoxes(
            @RequestParam(name = "onlyEmpty", defaultValue = "false") boolean onlyEmpty){
        List<CollectionBox> boxes = boxService.listBoxes(onlyEmpty);
        return ResponseEntity.ok(boxes);
    }

    @PostMapping("/{boxId}/assign")
    public ResponseEntity<CollectionBox> assignToEvent(@PathVariable("boxId") Long boxID,
                                                       @RequestParam("eventId") Long eventID){

        CollectionBox update = boxService.assignToEvent(boxID, eventID);
        return ResponseEntity.ok(update);
    }

    @PostMapping("/{boxId}/money")
    public ResponseEntity<CollectionBox> addMoney(@PathVariable("boxId") Long boxID,
                                                  @RequestParam("amount") BigDecimal amount,
                                                  @RequestParam("currency") String currency){
        CollectionBox update = boxService.addMoney(boxID, amount, currency);
        return ResponseEntity.ok(update);
    }

    @PostMapping("/{boxId}/empty")
    public ResponseEntity<Void> empty(@PathVariable("boxId") Long boxID){
        boxService.empty(boxID);
        return ResponseEntity.noContent().build();
    }

}
