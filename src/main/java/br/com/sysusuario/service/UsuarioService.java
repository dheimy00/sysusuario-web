package br.com.sysusuario.service;

import java.util.List;

import br.com.sysusuario.modelo.Usuario;

public interface UsuarioService{
	
	public void salvar(Usuario usuario);
	
	public void excluir(int id);
	
	public void alterar(Usuario usuario);
	
	public List<Usuario> listar();
	
	public Usuario getUser(int id);
	
	public boolean isUsuarioExiste(Usuario user);

}
