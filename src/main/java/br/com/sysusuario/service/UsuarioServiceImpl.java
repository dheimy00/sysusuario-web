package br.com.sysusuario.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sysusuario.dao.UsuarioDAO;
import br.com.sysusuario.dao.UsuarioDAOImpl;
import br.com.sysusuario.modelo.Usuario;

/**
 * @author Dheimy
 *
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	 private static List<Usuario> users;

	@Override
	@Transactional
	public void salvar(Usuario usuario) {
		usuarioDAO.salvar(usuario);
	}

	@Override
	@Transactional
	public void excluir(int id) {
		usuarioDAO.excluir(id);

	}

	@Override
	public void alterar(Usuario usuario) {
		usuarioDAO.alterar(usuario);

	}

	@Override
	@Transactional
	public List<Usuario> listar() {
		return usuarioDAO.listar();

	}

	public Usuario getUser(int id) {
		// TODO Auto-generated method stub
		return usuarioDAO.getUser(id);
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAOImpl usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public boolean isUsuarioExiste(Usuario user) {
		   return findByName(user.getNome())!= null;
	}
	
	 public Usuario findByName(String name) {
	        for(Usuario user : users){
	            if(user.getNome().equalsIgnoreCase(name)){
	                return user;
	            }
	        }
	        return null;
	    }

}
