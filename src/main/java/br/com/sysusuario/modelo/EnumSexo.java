package br.com.sysusuario.modelo;

public enum EnumSexo {
	MASCULINO(1,"Masculino"),
	FEMININO(2,"Feminino");
	
	private Integer id;
	private String sexo;
	
	EnumSexo(Integer id,String sexo){
	this.id = id;
	this.sexo = sexo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	

}
