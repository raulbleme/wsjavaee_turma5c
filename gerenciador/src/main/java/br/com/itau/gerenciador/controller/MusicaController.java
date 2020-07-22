package br.com.itau.gerenciador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.gerenciador.dao.MusicaDAO;
import br.com.itau.gerenciador.model.Musica;

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
}
