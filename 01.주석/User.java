package com.itwill.user;


public class User {
	/*
	 * =================================== 
	 * 이름 		널? 		유형
	 * =================================== 
	 * USERID 	NOT NULL VARCHAR2(100) 
	 * PASSWORD	NOT NULL VARCHAR2(100) 
	 * NAME 	NOT NULL VARCHAR2(200) 
	 * EMAIL 			 VARCHAR2(300)
	 * ===================================
	 */
	private String userId;
	private String password;
	private String name;
	private String email;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String password, String name, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	/*
	 *패쓰워드 일치여부 검사 
	 */
	public boolean isMatchPassword(String password){
		boolean isMatch=false;
		if(this.password.equals(password)){
			isMatch=true;
		}
		return isMatch;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]\n";
	}
	

}







