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

import br.com.itau.gerenciador.dao.MusicaDAO;
import br.com.itau.gerenciador.model.Musica;

@CrossOrigin("*")
@RestController
public class MusicaController {

	@Autowired
	private MusicaDAO dao;
	
	@PostMapping("/cadastrarmusica")
	public ResponseEntity<Musica> gravar(@RequestBody Musica musica){
		try {
			dao.save(musica);
			return ResponseEntity.ok(musica);
		} catch(Exception e) {
			return ResponseEntity.status(500).build();
		}
		
	}
	
	@GetMapping("/musicas")
	public ResponseEntity<ArrayList<Musica>> exibirTodasMusicas(){
		ArrayList<Musica> lista = (ArrayList<Musica>) dao.findAll();
		if(lista.size() == 0) {
			return ResponseEntity.status(500).build();
		}
		else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/musica/{id}")
	public ResponseEntity<Musica> getMusicaId(@PathVariable int id){
		Musica musica = dao.findById(id).orElse(null);
		if (musica == null) {
			return ResponseEntity.status(404).build();
		}
		else {
			return ResponseEntity.ok(musica);
		}
	}
}
