package fr.isika.cda.amap_generation.presentation.authentication;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.business.authentication.AmapAdminAuthenticationService;
import fr.isika.cda.amap_generation.business.profileManagement.ProfileManagementService;

@ManagedBean
@SessionScoped
public class AmapAdminAuthenticationManagedBean {

	@Inject
	private AmapAdminAuthenticationService authenticationService;
	
	@Inject
	private ProfileManagementService profileManagementService;
	
	private AuthenticationDto authenticationDto = new AuthenticationDto();

	public AmapAdminAuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(AmapAdminAuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public AuthenticationDto getAuthenticationDto() {
		return authenticationDto;
	}

	public void setAuthenticationDto(AuthenticationDto authenticationDto) {
		this.authenticationDto = authenticationDto;
	}
	
	public String amapConnection() {
		authenticationService.amapAuthentication(authenticationDto);
		this.profileManagementService.verificationOfSessionInfosAndSessionFilling();
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(true);
		session.getAttribute("idAmap");
		return "indexAmap?faces-redirect=true";
	}
	
	public String logout() {
		return authenticationService.logout();
	}
	
}
