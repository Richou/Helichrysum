package net.heanoria.appengine.helichrysum;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

import java.util.List;

import junit.framework.Assert;
import net.heanoria.appengine.helichrysum.entity.Artiste;
import net.heanoria.appengine.helichrysum.services.ArtisteService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;

public class ArtisteServiceTest {

	private ArtisteService artisteService;
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalUserServiceTestConfig()).setEnvIsLoggedIn(true)
			.setEnvAuthDomain("localhost").setEnvEmail("test@localhost");
	@Before
	public void onInit(){
		helper.setUp();
		artisteService = new ArtisteService();
	}
	
	@After
	public void onRelease(){
		helper.tearDown();
	}
	
	@Test
	public void testCreateAndList(){
		Artiste artiste = new Artiste();
		artiste.setNom("CocoRosie");
		artiste.setGenre("Freak Folk");
		
		artisteService.create(artiste);
		
		List<Artiste> savedArtistes = artisteService.listeArtistes();
		assertNotNull(savedArtistes);
		assertFalse(savedArtistes.isEmpty());
	}
	
	@Test
	public void testUpdate(){
		Artiste artiste = new Artiste();
		artiste.setNom("CocoRosie");
		artiste.setGenre("Folk");
		
		artiste = artisteService.create(artiste);
		assertEquals("Folk", artiste.getGenre());
		
		Artiste cocorosie = artisteService.getOne(artiste.getId());
		cocorosie.setGenre("Freak Folk");
		
		artisteService.update(cocorosie);
		
		cocorosie = artisteService.getOne(cocorosie.getId());
		assertEquals("Freak Folk", cocorosie.getGenre());
	}
	
	@Test
	public void testDelete(){
		Artiste artiste = new Artiste();
		artiste.setNom("CocoRosie");
		artiste.setGenre("Folk");
		
		artiste = artisteService.create(artiste);
		assertEquals("Folk", artiste.getGenre());		
		
		artisteService.delete(artiste.getId());
		
		try{
			artisteService.getOne(artiste.getId());
			Assert.fail("Must throw an IllegalArgumentException");
		}catch(IllegalArgumentException ex){
			
		}
	}
}
