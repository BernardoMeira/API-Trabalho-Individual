package br.com.biblioteca.trabalhoindividual.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.trabalhoindividual.model.Autor;
import br.com.biblioteca.trabalhoindividual.model.Editora;
import br.com.biblioteca.trabalhoindividual.model.InformacaoPublicacao;
import br.com.biblioteca.trabalhoindividual.model.Livro;
import br.com.biblioteca.trabalhoindividual.repository.AutorRepository;
import br.com.biblioteca.trabalhoindividual.repository.EditoraRepository;
import br.com.biblioteca.trabalhoindividual.repository.LivroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private EditoraRepository editoraRepository;

	@GetMapping
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.ok(livroRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
		Optional<Livro> livroOpt = livroRepository.findById(id);
		if (livroOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(livroOpt.get());
	}

	@GetMapping("/autor")
	public ResponseEntity<List<Livro>> listarPorAutor(@RequestParam String autor) {
		List<Livro> livros = livroRepository.buscarPorAutor(autor);
		return ResponseEntity.ok(livros);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro inserir(@Valid @RequestBody Livro livro) {
		InformacaoPublicacao informacaoPublicacao = livro.getInformacaoPublicacao();
		Autor autor = livro.getInformacaoPublicacao().getAutor();
		Editora editora = livro.getInformacaoPublicacao().getEditora();
		if (informacaoPublicacao != null) {
			if (autor != null) {
				Optional<Autor> autorOpt = autorRepository.findById(autor.getId());
				if (autorOpt.isPresent()) {
					informacaoPublicacao.setAutor(autorOpt.get());
				}
			}
			if (editora != null) {
				Optional<Editora> editoraOpt = editoraRepository.findById(editora.getId());
				if (editoraOpt.isPresent()) {
					informacaoPublicacao.setEditora(editoraOpt.get());
				}
			}
			livro.setInformacaoPublicacao(informacaoPublicacao);
		}
		return livroRepository.save(livro);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> alterar(@PathVariable Long id, @Valid @RequestBody Livro livro) {
		if (!livroRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		livro.setId(id);
		livro = livroRepository.save(livro);
		return ResponseEntity.ok(livro);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (!livroRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		livroRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
