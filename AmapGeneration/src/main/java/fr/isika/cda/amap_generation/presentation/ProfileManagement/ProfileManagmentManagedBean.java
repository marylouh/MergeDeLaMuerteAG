package fr.isika.cda.amap_generation.presentation.ProfileManagement;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import fr.isika.cda.amap_generation.business.authentication.AdminAuthenticationService;
import fr.isika.cda.amap_generation.business.authentication.AmapAdminAuthenticationService;
import fr.isika.cda.amap_generation.business.authentication.RegisteredAuthenticationService;
import fr.isika.cda.amap_generation.business.authentication.SupplierAuthenticationService;
import fr.isika.cda.amap_generation.business.profileManagement.ProfileManagementService;
import fr.isika.cda.amap_generation.model.amap.AmapAdministrator;
import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.model.user.Administrator;
import fr.isika.cda.amap_generation.model.user.Registered;
import fr.isika.cda.amap_generation.presentation.authentication.AdminAuthenticationDto;
import fr.isika.cda.amap_generation.presentation.authentication.AuthenticationDto;

@ManagedBean
@SessionScoped
public class ProfileManagmentManagedBean {

	@Inject
	private ProfileManagementService profileManagementService;

	@Inject
	private SupplierAuthenticationService supplierAuthenticationService;

	@Inject
	private AmapAdminAuthenticationService amapAdminAuthenticationService;

	@Inject
	private AdminAuthenticationService agAdminAuthenticationService;

	@Inject
	private RegisteredAuthenticationService registeredAuthenticationService;

	
	private AuthenticationDto authenticationDto = new AuthenticationDto();

	private AdminAuthenticationDto adminAuthenticationDto = new AdminAuthenticationDto();

	// Amap Admin connection

	public String amapConnection() {
		amapAdminAuthenticationService.amapAuthentication(authenticationDto);
		profileManagementService.verificationOfSessionInfosAndSessionFilling();
		return "index.xhtml";
	}
	
	public AmapAdministrator testIfAmapAdminConnected() {
		amapAdminAuthenticationService.amapAuthentication(authenticationDto);
		profileManagementService.verificationOfSessionInfosAndSessionFilling();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return (AmapAdministrator) session.getAttribute("amapAdminConnected");
	}

	public String logoutAmapAdmin() {
		return amapAdminAuthenticationService.logout();
	}

	// AG Admin connection

	public String adminConnection() {
		agAdminAuthenticationService.adminAuthentication(adminAuthenticationDto);
		profileManagementService.verificationOfSessionInfosAndSessionFilling();
		return "index.xhtml";

	}
	
	public Administrator testIfAgAdminConnected() {
		agAdminAuthenticationService.adminAuthentication(adminAuthenticationDto);
		profileManagementService.verificationOfSessionInfosAndSessionFilling();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return (Administrator) session.getAttribute("adminConnected");
	}

	public String logoutAgAdmin() {
		return agAdminAuthenticationService.logout();
	}

	// Registered connection

	public Registered testIfRegisteredConnected() {
		registeredAuthenticationService.registeredAuthentication(authenticationDto);
		profileManagementService.verificationOfSessionInfosAndSessionFilling();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return (Registered) session.getAttribute("registeredConnected");
	}

	public String logoutRegistered() {
		return registeredAuthenticationService.logout();
	}

	// Supplier connection

	public Supplier testIfSupplierConnected() {
		supplierAuthenticationService.supplierAuthentication(authenticationDto);
		profileManagementService.verificationOfSessionInfosAndSessionFilling();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return (Supplier) session.getAttribute("supplierConnected");
	}

	public String logoutSupplier() {
		return supplierAuthenticationService.logout();
	}

}
