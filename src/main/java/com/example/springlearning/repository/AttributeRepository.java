package com.example.springlearning.repository;

import com.example.springlearning.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    List<Attribute> findAttributesByComponentId(Long componentId);

    List<Attribute> findAttributesByComponentIdIn(Collection<Long> componentIds);
}