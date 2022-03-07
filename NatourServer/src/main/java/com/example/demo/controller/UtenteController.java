package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Utente;
import com.example.demo.repository.IUtenteRepository;

@RestController
public class UtenteController {
	
	@Autowired
	private IUtenteRepository utenterepo;
	
	//default map
	@GetMapping (value = "/")
	public String getPage () {
	return "Welcome";
	}
	
	@GetMapping (value = "/users")
	public List <Utente> getusers() {
	return (List<Utente>) utenterepo.findAll();
	}
	
	@PostMapping (value = "/registrati")
	public Boolean registrati (@RequestBody Utente user) {
		
		if(utenterepo.existsById(user.getUsername())) {
			return false;
		}
		utenterepo.save(user);
	return true;
	}
	@PostMapping (value = "utente/cambia")
	public Utente cambia(@RequestBody Utente user) {
		return utenterepo.save(user);
	}
	
	@GetMapping (value ="/login/{username}/{password}")
	public Utente login(@PathVariable String username, @PathVariable String password) throws Exception {
		
		Optional<Utente> user = utenterepo.findByUsernameAndPassword(username, password);
		if( user.isEmpty()) {
			throw new Exception("Accesso non riuscito");
		}
		return user.get();

	}
	
	

	
}
