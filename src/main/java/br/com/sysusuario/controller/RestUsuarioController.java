package br.com.sysusuario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import br.com.sysusuario.controller.RestUsuarioController;
import br.com.sysusuario.modelo.Usuario;
import br.com.sysusuario.service.interfaces.UsuarioService;
import br.com.sysusuario.util.ErrorType;

@RestController
@RequestMapping("/api")
public class RestUsuarioController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestUsuarioController.class);

	 @Autowired	
	 private UsuarioService usuarioService;
	 
		// -------------------Salvando usu�rio-------------------------------------------
		
		@RequestMapping(value = "/usuario/", method = RequestMethod.POST)
		public ResponseEntity<?> salvarUsuario(@RequestBody Usuario usuario, UriComponentsBuilder ucBuilder) {
			logger.info("Salvando usuario : {}", usuario);		
			usuarioService.salvarUsuario(usuario);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/api/usuario/{id}").buildAndExpand(usuario.getId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
	
		// -------------------Recuperar usu�rio usu�rio ------------------------------------------


		@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> getUsuario(@PathVariable("id") long id) {
			logger.info("Buscando o usu�rio com id {}", id);
			Usuario usuario  = usuarioService.obter(id);
			if (usuario == null) {
				logger.error("Usu�rio com id {} n�o encontra.", id);
				return new ResponseEntity(new ErrorType("Usu�rio com id " + id 
						+ " n�o encontra"), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
	
		

		// -------------------Recuperar todos os usu�rios---------------------------------------------


		@RequestMapping(value = "/usuario/", method = RequestMethod.GET)
		public ResponseEntity<List<Usuario>> listarUsuario() {
		List<Usuario> usuarios = usuarioService.listarUsuario();
			
			if (usuarios.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);		
			}
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		}
	
		// ------------------- Atualizar usu�rio ------------------------------------------------

		@RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> alterarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
			logger.info("Atualizando o usu�rio com id {}", id);

			Usuario atualUsuario = usuarioService.obter(id);

			if (atualUsuario == null) {
				logger.error("N�o foi poss�vel atualizar. Usu�rio com id {} n�o encontra.", id);
				return new ResponseEntity(new ErrorType("N�o foi poss�vel atualizar. Usu�rio com id " + id + " n�o encontra."),
						HttpStatus.NOT_FOUND);
			}

			atualUsuario.setNome(usuario.getNome());
			atualUsuario.setCpf(usuario.getCpf());

			usuarioService.alterarUsuario(atualUsuario);
			return new ResponseEntity<Usuario>(atualUsuario, HttpStatus.OK);
		}
		
		
		// ------------------- Excluido usu�rio-----------------------------------------

		@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> excluirUsuario(@PathVariable("id") long id) {
			logger.info("Buscando & Excluido o usu�rio com id {}", id);

			Usuario usuario = usuarioService.obter(id);
			if (usuario == null) {
				logger.error("N�o foi poss�vel excluir. Usu�rio com id {} n�o encontra.", id);
				return new ResponseEntity(new ErrorType("N�o foi poss�vel excluir. Usu�rio com id " + id + " n�o encontra."),
						HttpStatus.NOT_FOUND);
			}
			usuarioService.excluirUsuario(id);
			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
		}
	

}
