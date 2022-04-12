package br.com.generation.dtie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.dtie.model.Verificacao;
import br.com.generation.dtie.repository.VerificacaoRepository;

@RestController
@RequestMapping("/verificacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VerificacaoController {

	@Autowired
	private VerificacaoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Verificacao>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Verificacao> getByID(@PathVariable Long id){
		return  repository.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Verificacao>> getByNome(@PathVariable String status){
		return ResponseEntity.ok(repository.findAllByStatusContainingIgnoreCase(status));
	}
	
	@PostMapping
	public ResponseEntity<Verificacao> post(@RequestBody Verificacao verificacao){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(verificacao));
	}
	
	@PutMapping
	public ResponseEntity<Verificacao> put(@RequestBody Verificacao verificacao){
		return ResponseEntity.ok(repository.save(verificacao));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}