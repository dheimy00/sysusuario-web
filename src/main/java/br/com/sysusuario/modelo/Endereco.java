package br.com.sysusuario.modelo;

public class Endereco {
	
	private String logradouro;
	private String bairro;
	private String cep;
	private Integer numeo;
	
	public Endereco(){		}
		
	public Endereco(String logradouro, String bairro, String cep, Integer numeo) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.numeo = numeo;
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
	public Integer getNumeo() {
		return numeo;
	}
	public void setNumeo(Integer numeo) {
		this.numeo = numeo;
	}
	
	
	

}
