package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Fotografia;
import com.example.demo.repository.IFotoRepository;

@RestController
public class FotoController {

	@Autowired
	private IFotoRepository repo;
	
	@GetMapping(value = "/percorsi/{nomepercorso}/fotografie")
	public List<Fotografia> ottienifoto(@PathVariable String nomepercorso) {
		return repo.findByNomepercorso(nomepercorso);
	}
	
	@PostMapping(value = "percorsi/fotografie/aggiungi")
	public Iterable<Fotografia> salvafoto( @RequestBody List<Fotografia> foto) {
		return repo.saveAll(foto);
	}
	
	@GetMapping(value = "/percorsi/tutte/fotografie")
	public List<Fotografia> ottienifototutte() {
		return (List<Fotografia>) repo.findAll();
	}
	
	
}
