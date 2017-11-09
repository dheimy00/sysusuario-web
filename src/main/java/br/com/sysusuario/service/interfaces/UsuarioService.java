package br.com.sysusuario.service.interfaces;

import java.util.List;

import br.com.sysusuario.modelo.Usuario;



public interface UsuarioService {

	Usuario  obter (Long id);
	
	void salvarUsuario(Usuario usuario) ;
	
	void alterarUsuario(Usuario usuario);
	
	List<Usuario> listarUsuario();	
	
	void excluirUsuario(Long id) ;
	
	boolean isUsuarioExiste(Usuario usuario);
	
       
	    
}
