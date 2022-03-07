package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Segnalazionefoto;
import com.example.demo.repository.ISegnalazionefotoRepository;

@RestController
public class SegnalazionefotoController {

	@Autowired
	private ISegnalazionefotoRepository repo;
	
	@PostMapping(value = "percorsi/fotografie/segnala")
	public Iterable<Segnalazionefoto> segnalafoto(@RequestBody List<Segnalazionefoto> segnala){
		return repo.saveAll(segnala);
	}
	
	
	
}
