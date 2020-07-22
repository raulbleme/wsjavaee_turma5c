package br.com.itau.gerenciador.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.gerenciador.model.Artista;

public interface ArtistaDAO extends CrudRepository<Artista, Integer>{
	
	ArrayList<Artista> findByNacionalidade(String nacionalidade);
}
