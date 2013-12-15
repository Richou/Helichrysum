package net.heanoria.appengine.helichrysum.services;

import java.util.List;

import javax.inject.Named;

import net.heanoria.appengine.helichrysum.dao.AlbumDao;
import net.heanoria.appengine.helichrysum.entity.Album;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Api(name = "helichrysum", version = "v1", description = "Artiste API")
public class AlbumService {

	private AlbumDao albumDao = new AlbumDao();
	
	@ApiMethod(
			name = "helichrysum.albums.list",
			path = "albums/list",
			httpMethod = HttpMethod.GET)
	public List<Album> listeAlbums(){
		return albumDao.listAll();
	}

	@ApiMethod(
		name = "helichrysum.albums.create",
		path = "albums/create",
		httpMethod = HttpMethod.POST
	)
	public Album create(Album album){
		return albumDao.save(album);
	}
	
	@ApiMethod(
		name = "helichrysum.albums.update",
		path = "albums/update",
		httpMethod = HttpMethod.POST		
	)
	public void update(Album artiste){
		// Fais la meme chose que create mais par soucis de lisibilite, j'ai fais deux methodes
		albumDao.save(artiste);
	}
	
	@ApiMethod(
		name = "helichrysum.albums.get",
		path = "albums/see/{id}",
		httpMethod = HttpMethod.GET)
	public Album getOne(@Named("id") Long id){
		return albumDao.get(id);
	}
	
	@ApiMethod(
		name = "helichrysum.albums.delete",
		path = "albums/delete/{id}",
		httpMethod = HttpMethod.GET)
	public void delete(@Named("id") Long id){
		Album toDelete = albumDao.get(id);
		albumDao.delete(toDelete);
	}
}
