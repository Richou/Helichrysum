package net.heanoria.appengine.helichrysum.dao;

import com.googlecode.objectify.ObjectifyService;

import net.heanoria.appengine.helichrysum.entity.Artiste;

public class ArtisteDao extends ObjectifyDao<Artiste>{

	static{
		ObjectifyService.register(Artiste.class);
	}
	
	public ArtisteDao() {
		super(Artiste.class);
	}

}
