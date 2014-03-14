package net.heanoria.appengine.helichrysum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import junit.framework.Assert;
import net.heanoria.appengine.helichrysum.entity.Album;
import net.heanoria.appengine.helichrysum.services.AlbumService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;

public class AlbumServiceTest {

	private AlbumService albumService = null;
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalUserServiceTestConfig()).setEnvIsLoggedIn(true)
			.setEnvAuthDomain("localhost").setEnvEmail("test@localhost");
	
	@Before
	public void onInit(){
		helper.setUp();
		albumService = new AlbumService();
	}
	
	@After
	public void onRelease(){
		helper.tearDown();
	}
	
	@Test
	public void testCreateAndList(){
		Album album = new Album();
		album.setNom("Iron");
		
		albumService.create(album);
		
		List<Album> savedArtistes = albumService.listeAlbums();
		assertNotNull(savedArtistes);
		assertFalse(savedArtistes.isEmpty());
	}
	
	@Test
	public void testUpdate(){
		Album album = new Album();
		album.setNom("Iron");
		
		album = albumService.create(album);
		assertEquals("Iron", album.getNom());
		
		Album iron = albumService.getOne(album.getId());
		iron.setNom("Iron man");
		
		albumService.update(iron);
		
		iron = albumService.getOne(iron.getId());
		assertEquals("Iron man", iron.getNom());
	}
	
	@Test
	public void testDelete(){
		Album album = new Album();
		album.setNom("Iron");
		
		album = albumService.create(album);
		assertEquals("Iron", album.getNom());		
		
		albumService.delete(album.getId());
		
		try{
			albumService.getOne(album.getId());
			Assert.fail("Must throw an IllegalArgumentException");
		}catch(IllegalArgumentException ex){
			
		}
	}
}
