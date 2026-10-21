package org.example.jpaonetomany.repository;

import org.example.jpaonetomany.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommuneRepository extends JpaRepository<Kommune, String> {
}
