package net.heanoria.appengine.helichrysum.entity;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

@Entity
public class Artiste {

	@Id
	private Long id;
	
	@Index
	private String nom;
	private String genre;
	
	@Load
	private List<Ref<Album>> albums = new ArrayList<Ref<Album>>();
	
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

	public List<Album> getAlbums() {
		List<Album> albums = new ArrayList<Album>();
		
		for(Ref<Album> temp : this.albums)
			albums.add(temp.get());
		
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		List<Ref<Album>> tempAlbums = new ArrayList<Ref<Album>>();
		for(Album album : albums)
			tempAlbums.add(Ref.create(album));
		
		this.albums = tempAlbums;
	}
	
	public void addAlbum(Album album){
		this.albums.add(Ref.create(album));
	}
	
}
