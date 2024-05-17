package br.com.biblioteca.trabalhoindividual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.trabalhoindividual.model.Autor;
import br.com.biblioteca.trabalhoindividual.repository.AutorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping
	public ResponseEntity<List<Autor>> listar() {
		List<Autor> autores = autorRepository.findAll();
		return ResponseEntity.ok(autores);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Autor inserir(@RequestBody Autor autor) {
		return autorRepository.save(autor);
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Autor> inserirVarios(@RequestBody List<Autor> autores) {
		return autorRepository.saveAll(autores);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Autor> alterar(@PathVariable Long id, @Valid @RequestBody Autor autor) {
		if (!autorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		autor.setId(id);
		autor = autorRepository.save(autor);
		return ResponseEntity.ok(autor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (!autorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		autorRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
