package aca.bloger.service;

import aca.bloger.utils.EmailRegEX;

public class CheckMethods {

	//ovaj metod proverava velicne unetih stringova
	public static void checkSize(String s, int lenth, ErrorMessages error) {
		
		if(s.length() > lenth) {
			throw new AppException(error);
		}
	}
	//ovaj metod proverava da li uneti string pocinje sa velikim slovom
	public static void checkUpperCase(String s, ErrorMessages error) {
		
		if(hasUpperCase(s)==false) {
			throw new AppException(error);
		}
	}
	
	//ovaj metod proverava da li je uneta ispravna forma email-a
	public static void checkEmailForm(String email) {
		if(EmailRegEX.validate(email) == false) {
			throw new AppException(ErrorMessages.user_email_wrong_format);
		}
	}
	
	//ovaj metod poziva metode ispod njega, u kojima se nalazi logika i ukoliko sifra
	//nije u ispravom formatu onda baca app exception
	public static void checkPassword(String pass) {
		if(isContainNumber(pass)==false || checkPassLength(pass)==false || checkPassForm()==false) {
			throw new AppException(ErrorMessages.user_password_error);
		}
	}
	
	//Ovaj string se prosledjuje metodi isContainNumber koja kao argument prima sifru.
	//Ukoliko se u prosledjenoj sifri nalaze brojevi, metoda isContainNumber ce ukoloniti te brojeve
    //i ovom stringu dodeliti novu vrednost bez brojeva da bi se taj string kasnije 
	//prosledio metodi koja proverava da li string ima VELIKA slova. Ovaj postupak moramo da odradimo,
	//jer metoda koja proverava da li imamo velika slova brojeve vidi kao velika slova.
	private static String bezBroja;
	
	//ovaj metod proverava da li sifra sadrzi brojeve
		private static boolean isContainNumber(String pass) {
			
			boolean flag = false;
			String prazan = "";
			String broj;
			bezBroja = pass;
			
			for(int i = 0; i<10; i++) {
			 
				broj = prazan + i;
			
				if(pass.contains(broj)) {
					bezBroja = bezBroja.replace(broj, "");
					flag = true;
				}
			}
			return flag;
		}
	
	//ovaj metod proverava da li sifra ima velika slova
	private static boolean checkPassForm() {
		
		String upper = bezBroja.toUpperCase();
		
		char[]nizSlova = bezBroja.toCharArray();
		char[]nizVelikihSlova = upper.toCharArray();
		
		boolean flag = false;
		
		for(int i = 0; i<nizSlova.length; i++) {
			if(nizSlova[i] == nizVelikihSlova[i]) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	//ovaj metod proverava da li sifra ima minimalnu duzinu
	private static boolean checkPassLength(String pass) {
		
		boolean flag = false;
		
		if(pass.length() >= 6) {
			flag = true;
		}
		
		return flag;
	}
	
	//ovaj metod proverava da li uneti string pocinje sa velikim slovom
	private static boolean hasUpperCase(String s) {
		
		String upper = s.toUpperCase();
		
		char[]nizSlova = s.toCharArray();
		char[]nizVelikihSlova = upper.toCharArray();
		
		boolean flag = false;
		
		
		if(nizSlova[0] == nizVelikihSlova[0]) {
			flag = true;
		}
				
		return flag;
	}
	
}
