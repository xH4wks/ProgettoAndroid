package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Percorso;
import com.example.demo.repository.IPercorsoRepository;

@RestController
public class PercorsoController {

	@Autowired
	private IPercorsoRepository percorsoRepository;
	
	
	@GetMapping(value = "/percorsi")
	public List<Percorso> cercatutti(){		
		return (List<Percorso>) percorsoRepository.findAll();
	}
	
	@PostMapping (value = "/aggiungipercorso")
	public Boolean salvapercorso (@RequestBody Percorso percorso) {
		if(percorsoRepository.existsById(percorso.getNome())) {
			return false;
		}
		percorsoRepository.save(percorso);
	return true;
	}
	
	@GetMapping(value = "/percorsi/{nome}")
	public List<Percorso> cercapernome(@PathVariable String nome){
		return percorsoRepository.findByNomeContaining(nome);
	}
	
}
