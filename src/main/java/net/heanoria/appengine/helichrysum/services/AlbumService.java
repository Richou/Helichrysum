package net.heanoria.appengine.helichrysum.services;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;

import net.heanoria.appengine.helichrysum.dao.AlbumDao;
import net.heanoria.appengine.helichrysum.entity.Album;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Api(name = "helichrysum", version = "v1", description = "Artiste API")
public class AlbumService {

	private static final Logger log = Logger.getLogger(AlbumService.class.getName());
	
	private AlbumDao albumDao = new AlbumDao();
	
	@ApiMethod(
			name = "helichrysum.albums.list",
			path = "albums/list",
			httpMethod = HttpMethod.GET)
	public List<Album> listeAlbums(){
		List<Album> results = albumDao.listAll();
		if(results != null){
			log.info("Found " + results.size() + " Albums");
		}
		return results;
	}

	@ApiMethod(
		name = "helichrysum.albums.create",
		path = "albums/create",
		httpMethod = HttpMethod.POST
	)
	public Album create(Album album){
		Album alb = albumDao.save(album);
		if(alb != null){
			log.info("Album{name='" + alb.getNom() + "} created with id(" + alb.getId() + ")");
		}
		return alb;
	}
	
	@ApiMethod(
		name = "helichrysum.albums.update",
		path = "albums/update",
		httpMethod = HttpMethod.POST		
	)
	public void update(Album album){
		// Fais la meme chose que create mais par soucis de lisibilite, j'ai fais deux methodes
		albumDao.save(album);
		log.info("Artiste{name'" + album.getNom() + "', id=" + album.getId() + "} updated");
	}
	
	@ApiMethod(
		name = "helichrysum.albums.get",
		path = "albums/see/{id}",
		httpMethod = HttpMethod.GET)
	public Album getOne(@Named("id") Long id){
		Album album = albumDao.get(id);
		if(album != null){
			log.info("Found album{name='" + album.getNom() + "', id='" + album.getId() + "'}");
		}else{
			log.severe("ERROR - No Album with id(" + id + ") found.");
			throw new IllegalArgumentException("ERROR - No Album with id(" + id + ") found.");
		}
		return album;
	}
	
	@ApiMethod(
		name = "helichrysum.albums.delete",
		path = "albums/delete/{id}",
		httpMethod = HttpMethod.GET)
	public void delete(@Named("id") Long id){
		Album toDelete = albumDao.get(id);
		if(toDelete == null){
			log.severe("ERROR - No Album with id(" + id + ") found.");
			throw new IllegalArgumentException("ERROR - No Album with id(" + id + ") found.");
		}
		albumDao.delete(toDelete);
	}
}
