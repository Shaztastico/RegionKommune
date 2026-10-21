package org.example.jpaonetomany.repository;

import org.example.jpaonetomany.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, String> {
    Optional<Region> findByNavn(String navn);
}