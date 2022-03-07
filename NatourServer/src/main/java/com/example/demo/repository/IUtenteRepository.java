 package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Utente;


@Repository
public interface IUtenteRepository extends CrudRepository<Utente, String> {

	
	Optional<Utente> findByUsernameAndPassword(String username,String password);
	
}
