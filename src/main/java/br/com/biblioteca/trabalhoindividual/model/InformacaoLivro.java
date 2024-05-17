package br.com.biblioteca.trabalhoindividual.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class InformacaoLivro {

	private String sinopse;
	private Integer numeroPaginas;

	@Enumerated(EnumType.ORDINAL)
	private Categoria categoria;

	public String getSinopse() {
		return sinopse;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
