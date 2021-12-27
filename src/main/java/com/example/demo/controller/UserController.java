package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("users")

public class UserController {

	@Autowired
	private UserRepository userJpaRepository;

	@GetMapping("/all")
	public List<User> findAll() {
		return userJpaRepository.findAll();
	}

	@GetMapping(value = "/{name}")
	public User findByCode(@PathVariable final String nom) {
		return userJpaRepository.findByNom(nom);
	}

	@PostMapping(value = "/save")
	public void save(@RequestBody final User User) {
		userJpaRepository.save(User);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		System.out.println("id = "+id);
		User User = userJpaRepository.findById(Long.parseLong(id));
		userJpaRepository.delete(User);
	}
	
	@GetMapping(value = "/count")
	public long countUser() {
		return userJpaRepository.count();
	}

}
