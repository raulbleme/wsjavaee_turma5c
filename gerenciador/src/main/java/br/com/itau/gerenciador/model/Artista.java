package br.com.itau.gerenciador.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@JsonIgnoreProperties("artista")
	@OneToMany(mappedBy="artista", cascade=CascadeType.ALL)
	private List<Musica> musicas;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column(name="cadastro")
	private Date cadastro;
	
	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public Artista() {
		super();
	}
	
	public Artista(int id, String nomeartistico, String nacionalidade, List<Musica> musicas, Date cadastro) {
		super();
		this.id = id;
		this.nomeartistico = nomeartistico;
		this.nacionalidade = nacionalidade;
		this.musicas = musicas;
		this.cadastro = cadastro;
	}

	public void setAll(int id, String nomeartistico, String nacionalidade, List<Musica> musicas, Date cadastro) {
		this.id = id;
		this.nomeartistico = nomeartistico;
		this.nacionalidade = nacionalidade;
		this.musicas = musicas;
		this.cadastro = cadastro;
	}
	
	public String getAll() {
		return
				"ID do Artista: " + id + "\n" +
				"Nome Artístico: " + nomeartistico + "\n" +
				"Nacionalidade: " + nacionalidade;
	}
	
		public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
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
