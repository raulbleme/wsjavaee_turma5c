package br.com.itau.gerenciador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ARTISTAS")
public class Artista {
	
	@Column(name="id")
	@Id //define que esse atributo corresponde a chave primária
	@GeneratedValue(strategy=GenerationType.IDENTITY) //define auto incremento
	private int id;
	
	@Column(name="nomeartistico", length=40)
	private String nomeartistico;
	
	@Column(name="nacionalidade", length=70)
	private String nacionalidade;
	
	@OneToMany(mappedBy="artista", cascade=CascadeType.ALL)
	private List<Musica> musicas;
	
	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public Artista() {
		super();
	}

	public Artista(int id, String nomeartistico, String nacionalidade) {
		super();
		this.id = id;
		this.nomeartistico = nomeartistico;
		this.nacionalidade = nacionalidade;
	}

	public void setAll(int id, String nomeartistico, String nacionalidade) {
		this.id = id;
		this.nomeartistico = nomeartistico;
		this.nacionalidade = nacionalidade;
	}
	
	public String getAll() {
		return
				"ID do Artista: " + id + "\n" +
				"Nome Artístico: " + nomeartistico + "\n" +
				"Nacionalidade: " + nacionalidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeartistico() {
		return nomeartistico;
	}

	public void setNomeartistico(String nomeartistico) {
		this.nomeartistico = nomeartistico;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}	
}
