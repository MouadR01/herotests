package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.CrenauxSalle;
import com.example.demo.model.CrenauxSalleKey;

@Component
public interface CrenauxSalleRepository extends JpaRepository<CrenauxSalle, CrenauxSalleKey> {

	CrenauxSalle findById(long id);
}
