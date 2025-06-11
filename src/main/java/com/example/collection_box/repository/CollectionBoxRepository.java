package com.example.collection_box.repository;

import com.example.collection_box.entity.CollectionBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionBoxRepository extends JpaRepository<CollectionBox, Long> {
    List<CollectionBox> findBoxesByEmptyTrue();

}
