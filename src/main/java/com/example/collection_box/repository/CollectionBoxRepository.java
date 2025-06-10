package com.example.collection_box.repository;

import com.example.collection_box.entity.CollectionBox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionBoxRepository extends JpaRepository<CollectionBox, Long> {
    List<CollectionBox> findByEmpty(boolean empty);
}
