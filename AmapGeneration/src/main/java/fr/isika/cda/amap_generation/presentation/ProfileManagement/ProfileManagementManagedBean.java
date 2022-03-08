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
import fr.isika.cda.amap_generation.model.amap.TypeOfRentalFormulas;
import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.model.user.Administrator;
import fr.isika.cda.amap_generation.model.user.Person;
import fr.isika.cda.amap_generation.model.user.PersonType;
import fr.isika.cda.amap_generation.model.user.Registered;
import fr.isika.cda.amap_generation.presentation.authentication.AdminAuthenticationDto;
import fr.isika.cda.amap_generation.presentation.authentication.AuthenticationDto;

@ManagedBean
@SessionScoped
public class ProfileManagementManagedBean {

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
	
	private TypeOfRentalFormulas type1 = TypeOfRentalFormulas.FORMULE_1;
	private TypeOfRentalFormulas type2 = TypeOfRentalFormulas.FORMULE_2;
	private TypeOfRentalFormulas type3 = TypeOfRentalFormulas.FORMULE3;
	
	// Meta function
	
	public String authentication() {
		Person p = profileManagementService.authentication(authenticationDto);
		if (p.getPersonType().equals(PersonType.SUPPLIER)) {
			profileManagementService.verificationOfSessionInfosAndSessionFilling();
			return "indexAmap.xhml";
		} else if (p.getPersonType().equals(PersonType.REGISTERED)) {
			profileManagementService.verificationOfSessionInfosAndSessionFilling();
			return "indexAmap.xhml";
		} else {
			return "login.xhtml";
		}
	}

	// Amap Admin connection
	
	public String amapConnection() {
		amapAdminAuthenticationService.amapAuthentication(authenticationDto);
		profileManagementService.verificationOfSessionInfosAndSessionFilling();
		return "index.xhtml";
	}
	
	
	public AmapAdministrator testIfAmapAdminConnected() {
		//amapAdminAuthenticationService.amapAuthentication(authenticationDto);
		//profileManagementService.verificationOfSessionInfosAndSessionFilling();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Long id = (Long) session.getAttribute("idLogin");
		AmapAdministrator aw = this.profileManagementService.getAWbyId(id);
		return aw;
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
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Long id = (Long) session.getAttribute("idLogin");
		Registered reg = this.profileManagementService.getRegisteredByIdPerson(id);
		return reg;
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
	
	
	public TypeOfRentalFormulas testWhatTypeOfRentalFormula(){
		
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);  
		Long idAmap = (Long)session.getAttribute("idAmap");
		return this.profileManagementService.typeOfRentalFormulasByAmapId(idAmap);
	
	}
	

	public String logoutSupplier() {
		return supplierAuthenticationService.logout();
	}

	// Getters & Setters
	
	public ProfileManagementService getProfileManagementService() {
		return profileManagementService;
	}

	public void setProfileManagementService(ProfileManagementService profileManagementService) {
		this.profileManagementService = profileManagementService;
	}

	public SupplierAuthenticationService getSupplierAuthenticationService() {
		return supplierAuthenticationService;
	}

	public void setSupplierAuthenticationService(SupplierAuthenticationService supplierAuthenticationService) {
		this.supplierAuthenticationService = supplierAuthenticationService;
	}

	public AmapAdminAuthenticationService getAmapAdminAuthenticationService() {
		return amapAdminAuthenticationService;
	}

	public void setAmapAdminAuthenticationService(AmapAdminAuthenticationService amapAdminAuthenticationService) {
		this.amapAdminAuthenticationService = amapAdminAuthenticationService;
	}

	public AdminAuthenticationService getAgAdminAuthenticationService() {
		return agAdminAuthenticationService;
	}

	public void setAgAdminAuthenticationService(AdminAuthenticationService agAdminAuthenticationService) {
		this.agAdminAuthenticationService = agAdminAuthenticationService;
	}

	public RegisteredAuthenticationService getRegisteredAuthenticationService() {
		return registeredAuthenticationService;
	}

	public void setRegisteredAuthenticationService(RegisteredAuthenticationService registeredAuthenticationService) {
		this.registeredAuthenticationService = registeredAuthenticationService;
	}

	public AuthenticationDto getAuthenticationDto() {
		return authenticationDto;
	}

	public void setAuthenticationDto(AuthenticationDto authenticationDto) {
		this.authenticationDto = authenticationDto;
	}

	public AdminAuthenticationDto getAdminAuthenticationDto() {
		return adminAuthenticationDto;
	}

	public void setAdminAuthenticationDto(AdminAuthenticationDto adminAuthenticationDto) {
		this.adminAuthenticationDto = adminAuthenticationDto;
	}

	public TypeOfRentalFormulas getType1() {
		return type1;
	}

	public void setType1(TypeOfRentalFormulas type1) {
		this.type1 = type1;
	}

	public TypeOfRentalFormulas getType2() {
		return type2;
	}

	public void setType2(TypeOfRentalFormulas type2) {
		this.type2 = type2;
	}

	public TypeOfRentalFormulas getType3() {
		return type3;
	}

	public void setType3(TypeOfRentalFormulas type3) {
		this.type3 = type3;
	}
	
	

	
	
}
