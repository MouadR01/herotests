package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Crenaux;

@Component
public interface CrenauxRepository extends JpaRepository<Crenaux, Long> {

	Crenaux findById(long id);
}
