package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.BeanCreationNotAllowedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CrenauxSalle;
import com.example.demo.model.CrenauxSalleKey;
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
//		crenauxSalle.setUser(userRepository.findById(crenauxSalle.getUser().getId()));
//		crenauxSalle.setSalle(salleRepository.findById(crenauxSalle.getSalle().getId()));
//		crenauxSalle.setCrenaux(crenauxRepository.findById(crenauxSalle.getCrenaux().getId()));
//		crenauxSalleRepository.save(crenauxSalle);
		
		CrenauxSalle crenauxSalle1= new CrenauxSalle(new CrenauxSalleKey(crenauxSalle.getSalle().getId(),crenauxSalle.getCrenaux().getId()),crenauxSalle.getSalle(),crenauxSalle.getCrenaux(),crenauxSalle.getUser(),crenauxSalle.getDate()) ;
		crenauxSalleRepository.save(crenauxSalle1);
	}



	@GetMapping("/all")
	public CrenauxSalle findById(String salle, String crenaux){
		List<CrenauxSalle> list = crenauxSalleRepository.findAll();
		CrenauxSalle crs2= null;
		for(CrenauxSalle crs: list) {
			if(crs.getSalle().getId()== Integer.parseInt(salle)&&crs.getCrenaux().getId()==Integer.parseInt(crenaux))
				crs2=crs;
		}
		return crs2;
	}
	
	@DeleteMapping(value = "/delete/{salle,crenaux}")
	public void delete(String salle, String crenaux) {
		CrenauxSalle crenauxSalle = crenauxSalleRepository.findById(salle,crenaux);
		crenauxSalleRepository.delete(crenauxSalle);
	}
	
	@GetMapping(value = "/nbr")
	public long nbr() {
		return crenauxSalleRepository.count();
	}
}
