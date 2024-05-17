package br.com.biblioteca.trabalhoindividual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.trabalhoindividual.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
