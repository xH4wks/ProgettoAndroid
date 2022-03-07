package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Waypoint;
import com.example.demo.repository.IWaypointRepository;

@RestController
public class WaypointController {

	@Autowired
	private IWaypointRepository repository;

	
		
	@PostMapping (value = "/aggiungipercorso/waypoint")
	public String salvawaypoint (@RequestBody List<Waypoint> waypoint) {
		repository.saveAll(waypoint);	
	return "salvataggio completato";
		
	}
	
	@GetMapping(value = "/percorsi/{nome}/waypoint")
	public List<Waypoint> ottieniwaypointpercorso(@PathVariable String nome){
		return repository.findByNomeOrderByIndex(nome);
	}
	
}
