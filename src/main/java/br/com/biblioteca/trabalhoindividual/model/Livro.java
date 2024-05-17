package br.com.biblioteca.trabalhoindividual.model;

import java.util.Objects;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AssociationOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "livro")
@AssociationOverrides({
		@AssociationOverride(name = "informacaoPublicacao.autor", joinColumns = @JoinColumn(name = "autor_id")),
		@AssociationOverride(name = "informacaoPublicacao.editora", joinColumns = @JoinColumn(name = "editora_id")) })
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Preencha o titulo do livro!")
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String titulo;
	
	@Valid
	@Embedded
	@NotNull(message = "Preencha as informações do livro!")
	private InformacaoLivro informacaoLivro;
	
	@Valid
	@Embedded
	@NotNull(message = "Preencha as informações de publicidade!")
	private InformacaoPublicacao informacaoPublicacao;

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public InformacaoLivro getInformacaoLivro() {
		return informacaoLivro;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setInformacaoLivro(InformacaoLivro informacaoLivro) {
		this.informacaoLivro = informacaoLivro;
	}

	public InformacaoPublicacao getInformacaoPublicacao() {
		return informacaoPublicacao;
	}

	public void setInformacaoPublicacao(InformacaoPublicacao informacaoPublicacao) {
		this.informacaoPublicacao = informacaoPublicacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}
}
