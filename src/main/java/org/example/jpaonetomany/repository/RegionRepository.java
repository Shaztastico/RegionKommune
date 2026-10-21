package org.example.jpaonetomany.repository;

import org.example.jpaonetomany.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, String> {
}

