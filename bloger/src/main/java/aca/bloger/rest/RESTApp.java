package aca.bloger.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RESTApp extends Application{

	@Override
	public Set<Class<?>> getClasses() {
	
		Set<Class<?>> resources = new HashSet<>();
		
		resources.add(UserResource.class);
		
		return resources; 
	}

	
}
