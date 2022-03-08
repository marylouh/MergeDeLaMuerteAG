package fr.isika.cda.amap_generation.presentation.authentication;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.business.authentication.AdminAuthenticationService;
import fr.isika.cda.amap_generation.business.profileManagement.ProfileManagementService;

@ManagedBean
@SessionScoped
public class AdminAuthenticationManagedBean {

	@Inject
	private AdminAuthenticationService adminAuthenticationService;

	@Inject
	private ProfileManagementService profileManagementService;

	private AdminAuthenticationDto adminAuthenticationDto = new AdminAuthenticationDto();

	public AdminAuthenticationService getAdminAuthenticationService() {
		return adminAuthenticationService;
	}

	public void setAdminAuthenticationService(AdminAuthenticationService adminAuthenticationService) {
		this.adminAuthenticationService = adminAuthenticationService;
	}

	public AdminAuthenticationDto getAdminAuthenticationDto() {
		return adminAuthenticationDto;
	}

	public void setAdminAuthenticationDto(AdminAuthenticationDto adminAuthenticationDto) {
		this.adminAuthenticationDto = adminAuthenticationDto;
	}

	// Connection & Deconnection
	
	public String adminConnection() {
		adminAuthenticationService.adminAuthentication(adminAuthenticationDto);
		profileManagementService.verificationOfSessionInfosAndSessionFilling();
			return "index.xhtml";

	}

	public String logout() {
		return adminAuthenticationService.logout();
	}

}
