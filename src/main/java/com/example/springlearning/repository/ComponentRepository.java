package com.example.springlearning.repository;

import com.example.springlearning.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component, Long> {
    List<Component> findComponentsByReferenceIdAndReferenceName(Long referenceId, String referenceName);

    List<Component> findComponentsByReferenceIdInAndReferenceName(List<Long> referenceIds, String referenceName);
}