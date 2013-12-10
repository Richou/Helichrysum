package net.heanoria.appengine.helichrysum.dao;

import net.heanoria.appengine.helichrysum.entity.Album;

import com.googlecode.objectify.ObjectifyService;

public class AlbumDao extends ObjectifyDao<Album> {

	static{
		ObjectifyService.register(Album.class);
	}
	
	public AlbumDao() {
		super(Album.class);
	}
}
