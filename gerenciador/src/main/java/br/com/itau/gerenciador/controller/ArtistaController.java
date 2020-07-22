package br.com.itau.gerenciador.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.gerenciador.dao.ArtistaDAO;
import br.com.itau.gerenciador.model.Artista;

@RestController
public class ArtistaController {

	@Autowired
	private ArtistaDAO dao;
	
	@GetMapping("/artistas")
	public ResponseEntity<ArrayList<Artista>> exibirTodosArtistas(){
		ArrayList<Artista> lista =  (ArrayList<Artista>) dao.findAll();		
		if (lista.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/artista/{id}")
	public ResponseEntity<Artista> getArtistaId(@PathVariable int id){
		Artista resposta = dao.findById(id).orElse(null);
		if(resposta == null) {
			return ResponseEntity.status(404).build();
		}
		else {
			return ResponseEntity.ok(resposta);
		}
	}
	
	@GetMapping("/nacionalidade/{nacionalidade}")
	public ResponseEntity<ArrayList<Artista>> getArtistaNacionalidade(@PathVariable String nacionalidade){
		ArrayList<Artista> lista = dao.findByNacionalidade(nacionalidade);
		if(lista.size() == 0) {
			return ResponseEntity.status(404).build();
		}
		else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping("/cadastrarArtista")
	public ResponseEntity<Artista> gravar(@RequestBody Artista artista){
		try {
			dao.save(artista);
			return ResponseEntity.ok(artista);
		} catch(Exception e) {
			return ResponseEntity.status(500).build();
		}
		
	}

}
