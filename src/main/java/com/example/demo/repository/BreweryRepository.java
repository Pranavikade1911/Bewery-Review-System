package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Brewery;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {
    // Add custom query methods if needed
}
