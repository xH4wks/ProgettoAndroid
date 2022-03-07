package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Fotografia;


public interface IFotoRepository extends CrudRepository<Fotografia, String>{

	List<Fotografia> findByNomepercorso(String nomepercorso);
}
