package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.CrenauxSalle;

@Component
public interface CrenauxSalleRepository extends JpaRepository<CrenauxSalle, Long> {

	CrenauxSalle findById(long id);
}
