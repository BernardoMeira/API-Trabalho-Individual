package br.com.biblioteca.trabalhoindividual.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InformacaoPublicacao {

	@ManyToOne(fetch = FetchType.EAGER)
	private Autor autor;

	@ManyToOne(fetch = FetchType.EAGER)
	private Editora editora;

	@Column(name = "data_publicacao")
	private LocalDate dataPublicacao;

	public Autor getAutor() {
		return autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
}
