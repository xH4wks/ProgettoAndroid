package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Waypoint;

public interface IWaypointRepository extends CrudRepository<Waypoint, String>{

	List<Waypoint> findByNomeOrderByIndex(String nome);
	
	
}
