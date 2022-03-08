package fr.isika.cda.amap_generation.presentation.authentication;

import java.io.Serializable;

public class AuthenticationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4049934045312929306L;

	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
