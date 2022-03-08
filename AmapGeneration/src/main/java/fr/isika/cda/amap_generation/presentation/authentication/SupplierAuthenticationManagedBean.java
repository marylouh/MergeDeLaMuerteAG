package fr.isika.cda.amap_generation.presentation.authentication;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.business.authentication.SupplierAuthenticationService;
import fr.isika.cda.amap_generation.business.profileManagement.ProfileManagementService;
import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.model.user.Registered;

@ManagedBean
@SessionScoped
public class SupplierAuthenticationManagedBean {
	
	@Inject
	private SupplierAuthenticationService authenticationService;
	
	@Inject
	private ProfileManagementService profileManagementService;
	
	private AuthenticationDto authenticationDto = new AuthenticationDto();
	
	public AuthenticationDto getAuthenticationDto() {
		return authenticationDto;
	}

	public void setAuthenticationDto(AuthenticationDto authenticationDto) {
		this.authenticationDto = authenticationDto;
	}
	
	public Supplier testIfSupplierConnected() {
		authenticationService.supplierAuthentication(authenticationDto);
		profileManagementService.verificationOfSessionInfosAndSessionFilling();
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(false);
		return (Supplier) session.getAttribute("supplierConnected");
	}
	
	public String logout() {
		return authenticationService.logout();
	}
	
}
