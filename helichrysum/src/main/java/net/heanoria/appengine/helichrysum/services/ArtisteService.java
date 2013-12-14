package net.heanoria.appengine.helichrysum.services;

import java.util.List;

import javax.inject.Named;

import net.heanoria.appengine.helichrysum.dao.AlbumDao;
import net.heanoria.appengine.helichrysum.dao.ArtisteDao;
import net.heanoria.appengine.helichrysum.entity.Album;
import net.heanoria.appengine.helichrysum.entity.Artiste;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Api(name = "helichrysum", version = "v1", description = "Artiste API")
public class ArtisteService {

	private ArtisteDao artisteDao = new ArtisteDao();
	private AlbumDao albumDao = new AlbumDao();
	
	@ApiMethod(
		name = "helichrysum.artistes.list",
		path = "artistes/list",
		httpMethod = HttpMethod.GET)
	public List<Artiste> listeArtistes(){
		return artisteDao.listAll();
	}
	
	@ApiMethod(
		name = "helichrysum.artistes.create",
		path = "artistes/create",
		httpMethod = HttpMethod.POST
	)
	public Artiste create(Artiste artiste){
		return artisteDao.save(artiste);
	}
	
	@ApiMethod(
		name = "helichrysum.artistes.update",
		path = "artistes/update",
		httpMethod = HttpMethod.POST		
	)
	public void update(Artiste artiste){
		artisteDao.save(artiste);
	}
	
	@ApiMethod(
		name = "helichrysum.artistes.get",
		path = "artistes/see/{id}",
		httpMethod = HttpMethod.GET)
	public Artiste getOne(@Named("id") Long id){
		return artisteDao.get(id);
	}
	
	@ApiMethod(
		name = "helichrysum.artistes.delete",
		path = "artistes/delete/{id}",
		httpMethod = HttpMethod.GET)
	public void delete(@Named("id") Long id){
		Artiste toDelete = artisteDao.get(id);
		artisteDao.delete(toDelete);
	}
	
	@ApiMethod(
		name = "helichrysum.artistes.addAlbum",
		path = "artistes/add/album/{idArt}/{idAlb}",
		httpMethod = HttpMethod.GET)
	public void addAlbum(@Named("idArt") Long idArtiste, @Named("idAlb") Long idAlbum){
		Artiste artiste = artisteDao.get(idArtiste);
		Album album = albumDao.get(idAlbum);
		artiste.addAlbum(album);
		artisteDao.save(artiste);
	}
}
