package br.com.biblioteca.trabalhoindividual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.trabalhoindividual.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	@Query("SELECT l FROM Livro l WHERE l.informacaoPublicacao.autor.nome = :autor")
	List<Livro> buscarPorAutor(String autor);
}
