package br.com.sysusuario.dao.interfaces;

import java.util.List;

import br.com.sysusuario.modelo.Usuario;

public interface UsuarioDAO  {
	
	public Usuario  obter (Long id);
	
	public void salvar(Usuario usuario);
	
	public void excluir(Long id);
	
	public Usuario alterar(Usuario usuario);
	
	public List<Usuario> listar();
	
	public Usuario getUsuario(Long id);
	
	

}
