package br.com.sysusuario.service.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sysusuario.dao.dao.UsuarioDAOImpl;
import br.com.sysusuario.dao.interfaces.UsuarioDAO;
import br.com.sysusuario.modelo.Usuario;
import br.com.sysusuario.service.interfaces.UsuarioService;

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
	public void salvarUsuario(Usuario usuario) {
		usuarioDAO.salvar(usuario);
	}

	@Override
	@Transactional
	public void excluirUsuario(Long id) {
		usuarioDAO.excluir(id);

	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		usuarioDAO.alterar(usuario);

	}

	@Override
	@Transactional
	public List<Usuario> listarUsuario() {
		return usuarioDAO.listar();

	}

	public Usuario getUsuario(Long id) {
		// TODO Auto-generated method stub
		return usuarioDAO.getUsuario(id);
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAOImpl usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public boolean isUsuarioExiste(Usuario user) {
		   return false;
	}


	@Override
	public Usuario obter(Long id) {
		
      return usuarioDAO.obter(id);
	}

}
