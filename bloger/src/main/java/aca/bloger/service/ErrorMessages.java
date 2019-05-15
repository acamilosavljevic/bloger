package aca.bloger.service;

public class ErrorMessages {

	private int code;
	
	private String message;
	
	private ErrorMessages(int code, String message) {
		
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public static final ErrorMessages ok = new ErrorMessages(0, "Operation successful");
	public static final ErrorMessages db_problem = new ErrorMessages(100, "db_problem");
	
	public static final ErrorMessages user_id_doesnt_exists = new ErrorMessages(101, "User wiht given id doesnt exists!");
	
	public static final ErrorMessages user_name_doesnt_exists = new ErrorMessages(102, "User wiht given name doesnt exists!");
	public static final ErrorMessages user_name_too_long = new ErrorMessages(103, "Given user name has more than 30 characters!");
	public static final ErrorMessages user_name_upper_case = new ErrorMessages(103, "First letter of user name must be upper case!");
	
	public static final ErrorMessages user_surname_doesnt_exists = new ErrorMessages(104, "User wiht given surname doesnt exists!");
	public static final ErrorMessages user_surname_too_long = new ErrorMessages(105, "Given user surname has more than 30 characters!");
	public static final ErrorMessages user_surname_upper_case = new ErrorMessages(103, "First letter of user surname must be upper case!");
	
	public static final ErrorMessages user_nickname_exists = new ErrorMessages(106, "User wiht given nickname exists!");
	public static final ErrorMessages user_nickname_doesnt_exists = new ErrorMessages(101, "User wiht given nickname doesnt exists!");
	public static final ErrorMessages user_nickname_too_long = new ErrorMessages(107, "Given user nickname has more than 30 characters!");
	
	public static final ErrorMessages user_username_exists = new ErrorMessages(108, "User wiht given username exists!");
	public static final ErrorMessages user_username_doesnt_exists = new ErrorMessages(109, "User wiht given username doesnt exists!");
	public static final ErrorMessages user_username_too_long = new ErrorMessages(110, "Given user username has more than 30 characters!");
	
	public static final ErrorMessages user_email_wrong_format = new ErrorMessages(111, "User email has wrong form! Email must have " + 
			"the following characters: ...'@'...'.''com'");
	public static final ErrorMessages user_password_error = new ErrorMessages(112, "User password must contain:"
			+ " at least one upper-case letter, number and size must be over 6 characters!");
	
	public static final ErrorMessages invalid_query_string = new ErrorMessages(201, "Query string is not properly formed.");
	
}
