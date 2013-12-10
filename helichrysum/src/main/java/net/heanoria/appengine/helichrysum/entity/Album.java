package net.heanoria.appengine.helichrysum.entity;

import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Album {

	@Id
	private Long id;
	private String nom;
	private List<String> songs;
	
	public Album(){}
	public Album(String nom, List<String> songs){
		this.nom = nom;
		this.songs = songs;
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
	public List<String> getSongs() {
		return songs;
	}
	public void setSongs(List<String> songs) {
		this.songs = songs;
	}
	
}
