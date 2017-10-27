package br.com.sysusuario.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sysusuario.modelo.Usuario;
import br.com.sysusuario.service.UsuarioService;
import br.com.sysusuario.service.UsuarioServiceImpl;

@Controller
public class UsuarioController {
	
	 @Autowired	
	 private UsuarioService usuarioService;
	 
	 public UsuarioController(){
		 System.out.println("UsuarioController()");
		 Usuario usuario = new Usuario();
	 }
	 
	 @RequestMapping(value ="/novoUsuario",method = RequestMethod.GET)
	 public ModelAndView novoUsuario (ModelAndView model){
		 Usuario usuario = new Usuario();
		 model.addObject("usuario",usuario);
		 model.setViewName("cadastrar");
		 return model;
	 }
	 	 	
	 @RequestMapping(value = "/salvar",method =  RequestMethod.POST)
	 public ModelAndView salvar(@ModelAttribute Usuario usuario){
		if(usuario.getId() == 0){
			usuarioService.salvar(usuario);
		}else{
			usuarioService.alterar(usuario);
		}
		return new ModelAndView("redirect:/");		
	 }
	 
	    @RequestMapping(value = "/")
	    public ModelAndView listaUsuario(ModelAndView model) throws IOException {
	        List<Usuario> listaUsuario = usuarioService.listar();
	        model.addObject("listaUsuario", listaUsuario);
	        model.setViewName("listar");
	        return model;
	    }
	    
	    @RequestMapping(value = "/excluir", method = RequestMethod.GET)
	    public ModelAndView excluir(HttpServletRequest request) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        usuarioService.excluir(id);
	        return new ModelAndView("redirect:/");
	    }
	    
	    @RequestMapping(value = "/editar", method = RequestMethod.GET)
	    public ModelAndView editar(HttpServletRequest request) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Usuario usuario = usuarioService.getUser(id);
	        ModelAndView model = new ModelAndView("cadastrar");
	        model.addObject("usuario", usuario);
	 
	        return model;
	    }
	    

		public UsuarioService getUsuarioService() {
			return usuarioService;
		}

		public void setUsuarioService(UsuarioService usuarioService) {
			this.usuarioService = usuarioService;
		}
	        	 
	    
}
