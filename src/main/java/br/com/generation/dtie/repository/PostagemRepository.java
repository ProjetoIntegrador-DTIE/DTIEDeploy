package br.com.generation.dtie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.dtie.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{

	public List<Postagem> findAllByTextoContainingIgnoreCase(String texto);
	public List<Postagem> findAllByCepContainingIgnoreCase(String cep);
	public List<Postagem> findAllByUrgencia(boolean urgencia);
		
}