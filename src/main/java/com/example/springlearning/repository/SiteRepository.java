package com.example.springlearning.repository;

import com.example.springlearning.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Long> {

    List<Site> findSitesByOrderId(Integer orderId);
}