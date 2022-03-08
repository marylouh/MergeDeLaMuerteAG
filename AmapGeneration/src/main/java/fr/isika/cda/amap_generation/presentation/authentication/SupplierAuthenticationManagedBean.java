package fr.isika.cda.amap_generation.presentation.authentication;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.business.authentication.SupplierAuthenticationService;

@ManagedBean
@SessionScoped
public class SupplierAuthenticationManagedBean {
	@Inject
	private SupplierAuthenticationService authenticationService;
	
	private AuthenticationDto authenticationDto = new AuthenticationDto();
	
	public AuthenticationDto getAuthenticationDto() {
		return authenticationDto;
	}

	public void setAuthenticationDto(AuthenticationDto authenticationDto) {
		this.authenticationDto = authenticationDto;
	}
	
	public String supplierConnection() {
		return authenticationService.supplierAuthentication(authenticationDto);
	}
}
