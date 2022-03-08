package fr.isika.cda.amap_generation.presentation.authentication;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.business.authentication.RegisteredAuthenticationService;
import fr.isika.cda.amap_generation.business.profileManagement.ProfileManagementService;

@ManagedBean
@SessionScoped
public class RegisteredAuthenticationManagedBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1154584886L;

	@Inject
	private RegisteredAuthenticationService authenticationService;

	@Inject
	private ProfileManagementService profileManagementService;

	private AuthenticationDto authenticationDto = new AuthenticationDto();
	
	public AuthenticationDto getAuthenticationDto() {
		return authenticationDto;
	}

	public void setAuthenticationDto(AuthenticationDto authenticationDto) {
		this.authenticationDto = authenticationDto;
	}

	public String registeredConnection() {
		return authenticationService.registeredAuthentication(authenticationDto);
	}

	public String supplierConnection() {
		authenticationService.registeredAuthentication(authenticationDto);
		profileManagementService.verificationOfSessionInfosAndSessionFilling();
		return "indexAmap.xhtml";
	}
	
	public String logout() {
		return authenticationService.logout();
	}

}

