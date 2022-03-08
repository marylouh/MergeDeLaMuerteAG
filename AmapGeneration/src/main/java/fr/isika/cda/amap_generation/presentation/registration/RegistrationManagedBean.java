package fr.isika.cda.amap_generation.presentation.registration;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.business.registration.RegistrationService;
import fr.isika.cda.amap_generation.model.user.Gender;
import fr.isika.cda.amap_generation.model.user.TypeOfPlace;

@ManagedBean
@SessionScoped
public class RegistrationManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private RegistrationService registrationService;

	private RegistrationDto registrationHelper = new RegistrationDto();

	// méthodes pour utiliser les Enum dans les pages xhtml
	public Gender[] allGenders() {
		return Gender.values();
	}

	public TypeOfPlace[] allTypeOfPlace() {
		return TypeOfPlace.values();
	}
	// -------------------------------------------------------------------

	public RegistrationDto getRegistrationHelper() {
		return registrationHelper;
	}

	public void setRegistrationHelper(RegistrationDto registrationHelper) {
		this.registrationHelper = registrationHelper;
	}

	public String registerToAmap() {
		registrationService.register(registrationHelper);
		return "registered.xhtml?faces-redirect=true";
	}

	public String demo() throws ParseException {
		this.registrationHelper = new RegistrationDto();
		this.registrationHelper.setFirstName("Prénom");
		this.registrationHelper.setLastName("Nom");
		
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		this.registrationHelper.setBirthDate(sf.parse("10/12/2000"));
		
		this.registrationHelper.setGender(Gender.MADAME);
		this.registrationHelper.setLogin("login");
		this.registrationHelper.setPassword("password");
		this.registrationHelper.setAlias("alias");
		this.registrationHelper.setNumber("524");
		this.registrationHelper.setNameOfPlace("du managedBean");
		this.registrationHelper.setTypeOfPlace(TypeOfPlace.IMPASSE);
		this.registrationHelper.setPostalCode("12548");
		this.registrationHelper.setTown("ville");
		
		return "";
	}
}
