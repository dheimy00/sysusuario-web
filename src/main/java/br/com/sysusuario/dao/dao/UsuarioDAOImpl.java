package br.com.sysusuario.dao.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.sysusuario.dao.interfaces.UsuarioDAO;
import br.com.sysusuario.modelo.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	
	@Autowired
	private SessionFactory sessionFactory;	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void salvar(Usuario usuario) {
		sessionFactory.getCurrentSession().saveOrUpdate(usuario);
		
	}

	public void excluir(Long id) {
		Usuario usuario = (Usuario) sessionFactory.getCurrentSession().load(
                Usuario.class, id);
        if (null != usuario) {
            this.sessionFactory.getCurrentSession().delete(usuario);
        }
		
	}

	public Usuario alterar(Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);
        return usuario;
		
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		 return sessionFactory.getCurrentSession().createQuery("from Usuario")
	                .list();
	}

	public Usuario getUsuario(Long id) {
	    return (Usuario) sessionFactory.getCurrentSession().get(
	    		Usuario.class, id);
	}

	@Override
	public Usuario obter(Long id) {	
		return (Usuario) sessionFactory.getCurrentSession().get(
	    		Usuario.class, id);
	}


}
