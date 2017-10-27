package br.com.sysusuario.dao;

import java.util.List;

import br.com.sysusuario.modelo.Usuario;

public interface UsuarioDAO  {
	
	public void salvar(Usuario usuario);
	
	public void excluir(int id);
	
	public Usuario alterar(Usuario usuario);
	
	public List<Usuario> listar();
	
	public Usuario getUser(int id);
	
	

}
