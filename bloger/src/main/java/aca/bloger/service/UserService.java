package aca.bloger.service;


import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import aca.bloger.domen.User;
import aca.bloger.domen.jpa.UserQueries;
import aca.bloger.jsf.ControllBean;


@Stateless
public class UserService {
	
	@PersistenceContext
	private EntityManager em;
	@Inject
	private ControllBean cb;
	
	//Kreira user-a
	public User createUser(User user) {
		
		User u = UserQueries.findByNickname(em, user.getNickname());
		
		//proverava duzinu imena
		CheckMethods.checkSize(user.getName(), 10, ErrorMessages.user_name_too_long);
		//proverava da li ime pocinje sa velikim slovom
		CheckMethods.checkUpperCase(user.getName(), ErrorMessages.user_name_upper_case);
		//proverava duzinu prezimena
		CheckMethods.checkSize(user.getSurname(), 10, ErrorMessages.user_surname_too_long);
		//proverava da li prezime pocinje sa velikim slovom
		CheckMethods.checkUpperCase(user.getSurname(), ErrorMessages.user_surname_upper_case);
		//proverava duzinu nadimka
		CheckMethods.checkSize(user.getNickname(), 20, ErrorMessages.user_nickname_too_long);
		//proverava duzinu korisnickog imena
		CheckMethods.checkSize(user.getUsername(), 20, ErrorMessages.user_username_too_long);
		//proverava da li je email u ispravnom formatu
		CheckMethods.checkEmailForm(user.getEmail());
		//proverava da li je sifra u ispravnom formatu
		CheckMethods.checkPassword(user.getPassword());
		
		if(u != null) {
			throw new AppException(ErrorMessages.user_nickname_exists);
		}
		
		em.persist(user);
		
		return user;
	}
	
	//vraca sve sortirane user-e
	public List<User> getAllUsers() {
		
		List<User> list = UserQueries.getAllUserss(em);
		
		Collections.sort(list, new IdComparator());
		
		return list;
	}
	
	
	public User getSingleUser(int id) {
		
		User product = UserQueries.getUserById(em, id);
		
		if(product == null) {
			throw new AppException(ErrorMessages.user_id_doesnt_exists);
		}
		return product;
	}
	
	public User updateUser(User product) {
		
		User u = UserQueries.getUserById(em, product.getId());
		
			u.setName(product.getName());
			u.setSurname(product.getSurname());
			u.setNickname(product.getNickname());
			
		return u;
	}
	
	public void deleteUser(int id) {
		
		User u = UserQueries.getUserById(em, id);
		
		if(u == null) {
			throw new AppException(ErrorMessages.user_id_doesnt_exists);
		}
		
		em.remove(u);
	}
	
	public boolean checkLogging() {
		
		boolean flag = false;
		
		User u = UserQueries.findByUsername(em, cb.getLogUserName());
		
//		if(cb.getLogUserName().equals(null)) {
//			throw new AppException(ErrorMessages.invalid_query_string);
//		}
		
		if(u == null) {
			throw new AppException(ErrorMessages.user_username_doesnt_exists);
		}
		
		if(u.getPassword().equals(cb.getLogPassword())) {
			
			flag = true;
		}
		
		return flag;
		
	}
	
}
