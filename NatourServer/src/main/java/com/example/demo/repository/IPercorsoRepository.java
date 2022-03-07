package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Percorso;

@Repository
public interface IPercorsoRepository extends CrudRepository<Percorso, String>{

	List<Percorso>findByNomeContaining(String nome);
}
