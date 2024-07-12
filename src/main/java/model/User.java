package model;

public class User {
	
	private Long id;
	private String nameUser;
	private String email;
	private String password;
	private String birthdate;
	private String country;
	
	public User() {
		super();
	}

	public User(Long id, String nameUser, String email, String password, String birthdate, String country) {
		super();
		this.id = id;
		this.nameUser = nameUser;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	

}
