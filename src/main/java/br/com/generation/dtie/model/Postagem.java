package br.com.generation.dtie.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 10, max = 1000)
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime date;

	@NotNull
	@Size(min = 8, max = 8)
	private String cep;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String endereco;
	
	@Size(max = 100)
	private String complemento;
	
	@NotNull
	@Size(min = 4, max = 50)
	private String ufNome;
	
	@NotNull
	@Size(min = 2, max = 2)
	private String ufSigla;
	
	@NotNull
	private boolean urgencia;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Verificacao verificacao;

	
	
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getUfNome() {
		return ufNome;
	}

	public void setUfNome(String ufNome) {
		this.ufNome = ufNome;
	}

	public String getUfSigla() {
		return ufSigla;
	}

	public void setUfSigla(String ufSigla) {
		this.ufSigla = ufSigla;
	}

	public boolean isUrgencia() {
		return urgencia;
	}

	public void setUrgencia(boolean urgencia) {
		this.urgencia = urgencia;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Verificacao getVerificacao() {
		return verificacao;
	}

	public void setVerificacao(Verificacao verificacao) {
		this.verificacao = verificacao;
	}
	
	
	
}