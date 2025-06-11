package com.example.collection_box.controller;

import com.example.collection_box.entity.CollectionBox;
import com.example.collection_box.service.CollectionBoxService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/boxes")
public class CollectionBoxController {
    private final CollectionBoxService boxService;

    public CollectionBoxController(CollectionBoxService boxService, BoxMapper boxMapper){
        this.boxService = boxService;
        this.boxMapper = boxMapper;
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
}
