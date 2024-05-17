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

import br.com.biblioteca.trabalhoindividual.model.Editora;
import br.com.biblioteca.trabalhoindividual.repository.EditoraRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	private EditoraRepository editoraRepository;

	@GetMapping
	public ResponseEntity<List<Editora>> listar() {
		List<Editora> editoras = editoraRepository.findAll();
		return ResponseEntity.ok(editoras);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Editora inserir(@RequestBody Editora editora) {
		return editoraRepository.save(editora);
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Editora> inserirVarios(@RequestBody List<Editora> editoras) {
		return editoraRepository.saveAll(editoras);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Editora> alterar(@PathVariable Long id, @Valid @RequestBody Editora editora) {
		if (!editoraRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		editora.setId(id);
		editora = editoraRepository.save(editora);
		return ResponseEntity.ok(editora);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (!editoraRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		editoraRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
