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

import com.example.demo.model.CrenauxSalle;
import com.example.demo.repository.CrenauxRepository;
import com.example.demo.repository.CrenauxSalleRepository;
import com.example.demo.repository.SalleRepository;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("crenauxSalles")
public class CrenauxSalleController {
	@Autowired
	private CrenauxSalleRepository crenauxSalleRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CrenauxRepository crenauxRepository;
	
	@Autowired
	private SalleRepository salleRepository;
	
	@PostMapping("/save")
	public void save(@RequestBody CrenauxSalle crenauxSalle){
		System.out.println(crenauxSalle);
		crenauxSalle.setUser(userRepository.findById(crenauxSalle.getUser().getId()));
		crenauxSalle.setSalle(salleRepository.findById(crenauxSalle.getSalle().getId()));
		crenauxSalle.setCrenaux(crenauxRepository.findById(crenauxSalle.getCrenaux().getId()));
		crenauxSalleRepository.save(crenauxSalle);
	}


	@GetMapping("/all")
	public List<CrenauxSalle> findAll(){
		return crenauxSalleRepository.findAll();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		System.out.println("id = "+id);
		CrenauxSalle crenauxSalle = crenauxSalleRepository.findById((id));
		crenauxSalleRepository.delete(crenauxSalle);
	}
	
	@GetMapping(value = "/nbr")
	public long nbr() {
		return crenauxSalleRepository.count();
	}
}
