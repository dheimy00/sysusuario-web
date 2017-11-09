package br.com.sysusuario.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable{
	

	private static final long serialVersionUID = -5877635464922626957L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,length= 50)
	private String logradouro;
	
	@Column(nullable = false,length= 50)
	private String bairro;
	
	@Column(nullable = false,length= 50)
	private String cep;
	
	@Column(nullable = false,length= 50)
	private Integer numero;
	
	public Endereco(){		}
		
	public Endereco(String logradouro, String bairro, String cep, Integer numero) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
	}



	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumeo(Integer numeo) {
		this.numero = numeo;
	}
	
	
	

}
