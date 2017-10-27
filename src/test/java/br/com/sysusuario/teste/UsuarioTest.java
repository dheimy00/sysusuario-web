package br.com.sysusuario.teste;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import br.com.sysusuario.modelo.Usuario;

public class UsuarioTest {

    public static final String REST_SERVICE_URI = "http://localhost:8081/sysusuario-web";
   

    /* GET */
	 private static void getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Usuario user = restTemplate.getForObject(REST_SERVICE_URI+"/usuario/2", Usuario.class);      
        System.out.println(user.toString());
    }
    
    
    
    /* POST */
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        Usuario user = new Usuario(5,"Sarah","3423114231","10");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/usuario/", user, Usuario.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
    
    /* PUT */
    private static void updateUser() {
        System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        Usuario user  = new Usuario(2,"Tomy","3423114231", "7");
        restTemplate.put(REST_SERVICE_URI+"/usuario/3", user);
        System.out.println(user.toString());
    }
    
    /* DELETE */
    private static void deleteUser() {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/usuario/3");
    }
    
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        System.out.println("Testing listAllUsers API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/usuario/", List.class);
         
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("Usuario : Nome="+map.get("nome")+", CPF="+map.get("cpf")+", Idade="+map.get("idade"));
            }
        }else{
            System.out.println("No user exist----------");
        }
    }
    
    
	 public static void main(String args[]){
		 createUser();	      	 
	 }
}
