package br.com.generation.dtie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.generation.dtie.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository <Tema, Long> {
	public List<Tema> findAllByCategoriaContainingIgnoreCase(String categoria);
	
}