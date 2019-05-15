package aca.bloger.service;

import java.util.Comparator;

import aca.bloger.domen.User;

public class IdComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		User a = (User) o1;
		User b = (User) o2;
		
		if(a.getId() == b.getId()) {
			return 0;
			
		}else if(a.getId() < b.getId()) {
			return 1;
			
		}else {
			return -1;
		}
	}
	

}
