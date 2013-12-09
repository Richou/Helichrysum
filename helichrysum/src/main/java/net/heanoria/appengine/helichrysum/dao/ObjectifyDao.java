package net.heanoria.appengine.helichrysum.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;

public class ObjectifyDao<T>{

	private Class<T> clazz;
	
	protected ObjectifyDao(Class<T> clazz){
		this.clazz = clazz;
	}
	
	public void save(T entity){
		ObjectifyService.ofy().save().entity(entity).now();
	}
	
	public List<T> listAll(){
		Query<T> all = ofy().load().type(this.clazz);
		return all.list();
	}
	
	public T get(Long id){
		return ofy().load().type(this.clazz).id(id).now();
	}
	
	public void delete(T entity){
		ofy().delete().entity(entity).now();
	}
}
