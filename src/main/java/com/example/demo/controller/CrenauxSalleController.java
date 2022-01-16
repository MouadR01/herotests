package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.BeanCreationNotAllowedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	public List<CrenauxSalle> findAll(){
		return crenauxSalleRepository.findAll();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) long id) {
		System.out.println("id = "+id);
		CrenauxSalle crenauxSalle = crenauxSalleRepository.findById((id));
		crenauxSalleRepository.delete(crenauxSalle);
	}
	
	@GetMapping("/alll")
	public CrenauxSalle findByIdd(String salle, String crenaux) {
		List<CrenauxSalle> lst = crenauxSalleRepository.findAll();
		CrenauxSalle crs2 = null;
		for (CrenauxSalle crs : lst) {
			if (crs.getSalle().getId() == Integer.parseInt(salle) && crs.getCrenaux().getId() == Integer.parseInt(crenaux)) {
				crs2 = crs;
			}
		}
		return crs2;
	}

	@DeleteMapping(value = "/deletee/{salle,crenaux}")
	public void delete( String salle, String creneaux) {
		CrenauxSalle crs = findByIdd(salle,creneaux);
		crenauxSalleRepository.delete(crs);
	}
	@GetMapping(value = "/nbr")
	public long nbr() {
		return crenauxSalleRepository.count();
	}
	
	@PostMapping(value = "/findme/{salle,crenaux}")
    public void valider(String salle, String creneaux) {
        String admin = "admin";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        CrenauxSalle crs = findByIdd(salle, creneaux);
        String valide = "valide";
        String user = "user";
        String reject = "reject";
        String trt = "En cours de traitement...";

        if (username.equals(admin)) {
            crs.setStatus("valide");
            crenauxSalleRepository.save(crs);
        } else if (username.equals(user) && (crs.getStatus().equals(reject) || crs.getStatus().equals(trt))) {
            crs.setStatus("En cours de traitement...");
            crenauxSalleRepository.save(crs);
        }

    }
}
