package net.heanoria.appengine.helichrysum.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Artiste {

	@Id
	private Long id;
	
	@Index
	private String nom;
	private String genre;
	
	public Artiste(){}
	
	public Artiste(String nom,  String genre){
		this.nom = nom;
		this.genre = genre;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
