package aca.bloger.jsf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import org.primefaces.PrimeFaces;

import aca.bloger.domen.User;
import aca.bloger.service.AppException;
import aca.bloger.service.ErrorMessages;
import aca.bloger.service.UserService;

@Named
@SessionScoped
public class ControllBean implements Serializable{

	//default serial Id
	private static final long serialVersionUID = 1L;

	@Inject
	UserService userService;
	
	private User user = new User();
	
	private String logUserName;
	private String logPassword;
	
	public ControllBean() {
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//kreira user-a
	public void createUser() {
		
		try {
			userService.createUser(user);
			
			user = new User();
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacija uspela", "Uspesno kreiran user");
	         
	        PrimeFaces.current().dialog().showMessageDynamic(message);	  
	        
	        
	    }catch (PersistenceException pe) {
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error code: " + 
			                                         ErrorMessages.db_problem.getCode(), ErrorMessages.db_problem.getMessage());
	        PrimeFaces.current().dialog().showMessageDynamic(message);
			
		}catch (AppException appEx) {
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error code: " + appEx.getError().getCode(), appEx.getError().getMessage());
	         
	        PrimeFaces.current().dialog().showMessageDynamic(message);
			    
		}
	}
	
	public String backToHomePage() {
		
		return "homePage?faces-redirect=true";
	}
	
	
	public void log() {
		
		try {
			
			if(userService.checkLogging() == true) {

				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacija uspela", "Uspesno ulogovan user");
		         
		        PrimeFaces.current().dialog().showMessageDynamic(message);	
		        
			}else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operacija nije uspela", "Pogresan password");
		         
		        PrimeFaces.current().dialog().showMessageDynamic(message);	  
		        
		    }
			
		} catch (AppException appEx) {
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error code: "+appEx.getError().getCode(), 
					appEx.getError().getMessage());
	         
	        PrimeFaces.current().dialog().showMessageDynamic(message);	 
	        
	    }
		
		
		
	}
	
	//dovlaci sve user-e
	public List<User> listOfUsers(){
		
		return userService.getAllUsers();
	}

	public String getLogUserName() {
		return logUserName;
	}

	public void setLogUserName(String logUserName) {
		this.logUserName = logUserName;
	}

	public String getLogPassword() {
		return logPassword;
	}

	public void setLogPassword(String logPassword) {
		this.logPassword = logPassword;
	}
	
	
	
}
