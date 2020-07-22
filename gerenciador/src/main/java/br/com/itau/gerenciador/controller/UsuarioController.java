package br.com.itau.gerenciador.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.gerenciador.dao.UsuarioDAO;
import br.com.itau.gerenciador.model.Usuario;

@CrossOrigin("*")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ResponseEntity<ArrayList<Usuario>> exibirTodosUsuarios(){
		ArrayList<Usuario> lista =  (ArrayList<Usuario>) dao.findAll();		
		if (lista.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuarioId(@PathVariable int id){
		Usuario resposta = dao.findById(id).orElse(null);
		if(resposta == null) {
			return ResponseEntity.status(404).build();
		}
		else {
			return ResponseEntity.ok(resposta);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> efetuarLogin(@RequestBody Usuario usuario){
		Usuario objeto = dao.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		if(objeto == null) {
			return ResponseEntity.status(403).build();
		}
		else {
			return ResponseEntity.ok(objeto);
		}
	}

}
