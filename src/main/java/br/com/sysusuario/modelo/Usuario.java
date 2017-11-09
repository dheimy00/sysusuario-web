package br.com.sysusuario.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 491915349669683306L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Nome",nullable = false,length= 50)
	private String nome;
	
	@Column(name="CPF",nullable = false,length= 50)
	private String cpf;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Contato contato;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	
	public Usuario(){}
	
			
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Contato getContato() {
		return contato;
	}


	public void setContato(Contato contato) {
		this.contato = contato;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
