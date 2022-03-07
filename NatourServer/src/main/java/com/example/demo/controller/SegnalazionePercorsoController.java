package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Segnalazionepercorso;
import com.example.demo.repository.ISegnalazionepercorsoRepository;

@RestController
public class SegnalazionePercorsoController {

	@Autowired
	private ISegnalazionepercorsoRepository repo;
	
	@PostMapping(value = "/percorsi/segnala")
	public Segnalazionepercorso segnalapercorso(@RequestBody Segnalazionepercorso segnalazione){
		
			return repo.save(segnalazione);
	}
	
	
}
