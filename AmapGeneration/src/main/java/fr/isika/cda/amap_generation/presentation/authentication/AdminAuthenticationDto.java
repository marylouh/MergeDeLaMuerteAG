package fr.isika.cda.amap_generation.presentation.authentication;

import java.io.Serializable;

public class AdminAuthenticationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4049934045312929306L;

	private String loginAdmin;
	private String passwordAdmin;

	public String getLoginAdmin() {
		return loginAdmin;
	}

	public void setLoginAdmin(String loginAdmin) {
		this.loginAdmin = loginAdmin;
	}

	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

}
