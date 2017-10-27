package br.com.sysusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sysusuario.modelo.Usuario;
import br.com.sysusuario.service.UsuarioService;

@RestController
public class RestUsuarioController {

	 @Autowired	
	 private UsuarioService usuarioService;
	 
	 
	 //-------------------Retrieve All Users--------------------------------------------------------
	 
	 @RequestMapping(value = "/usuario/", method = RequestMethod.GET)
	    public ResponseEntity<List<Usuario>> listAllUsers() {
	        List<Usuario> users = usuarioService.listar();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
	    }
	 
	 

	    //-------------------Retrieve Single User--------------------------------------------------------
	 
	  @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Usuario> getUser(@PathVariable("id") int id) {
	        System.out.println("Fetching User with id " + id);
	        Usuario user = usuarioService.getUser(id);
	        if (user == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	    }
	  
	  //-------------------Create a User--------------------------------------------------------
	     
	    @RequestMapping(value = "/usuario/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody Usuario user,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + user.getNome());
	 
	        if (usuarioService.isUsuarioExiste(user)) {
	            System.out.println("A User with name " + user.getNome() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        usuarioService.salvar(user);	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/usuario/{id}").buildAndExpand(user.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	    
	    //------------------- Update a User --------------------------------------------------------
	     
	    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Usuario> updateUser(@PathVariable("id") int id, @RequestBody Usuario user) {
	        System.out.println("Updating User " + id);
	         
	        Usuario currentUser = usuarioService.getUser(id);
	         
	        if (currentUser==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentUser.setNome(user.getNome());
	        currentUser.setCpf(user.getCpf());
	        currentUser.setIdade(user.getIdade());
	         
	        usuarioService.alterar(currentUser);
	        return new ResponseEntity<Usuario>(currentUser, HttpStatus.OK);
	    }
	    
	    //------------------- Delete a User --------------------------------------------------------
	     
	    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Usuario> deleteUser(@PathVariable("id") int id) {
	        System.out.println("Fetching & Deleting User with id " + id);
	 
	        Usuario user = usuarioService.getUser(id);
	        if (user == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	        }
	 
	        usuarioService.excluir(id);
	        return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	    }
	 
	  
	  

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	 
	 
	
}
