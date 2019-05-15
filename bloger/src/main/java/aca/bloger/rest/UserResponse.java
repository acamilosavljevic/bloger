package aca.bloger.rest;

import aca.bloger.domen.User;

public class UserResponse extends RESTResponse{

	private User author;

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	
}
