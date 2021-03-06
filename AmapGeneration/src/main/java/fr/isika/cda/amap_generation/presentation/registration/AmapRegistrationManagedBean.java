package fr.isika.cda.amap_generation.presentation.registration;

import java.io.Serializable;
import java.text.ParseException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.business.registration.AmapRegistrationService;
import fr.isika.cda.amap_generation.model.user.TypeOfPlace;

@ManagedBean
@SessionScoped
public class AmapRegistrationManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 149887789L;

	@Inject
	private AmapRegistrationService amapRegistrationService;

	private AmapRegistrationDto amapRegistrationHelper = new AmapRegistrationDto();

	public TypeOfPlace[] allTypeOfPlaces() {
		return TypeOfPlace.values();
	}

	public AmapRegistrationDto getAmapRegistrationHelper() {
		return amapRegistrationHelper;
	}

	public void setAmapRegistrationHelper(AmapRegistrationDto amapRegistrationHelper) {
		this.amapRegistrationHelper = amapRegistrationHelper;
	}

	public void setAmapRegistrationService(AmapRegistrationService amapRegistrationService) {
		this.amapRegistrationService = amapRegistrationService;
	}

	public String registerToAmap() {
		amapRegistrationService.createAmap(amapRegistrationHelper);
		return "registered.xhtml?faces-redirect=true";
	}

	public String demo() throws ParseException {
		this.amapRegistrationHelper = new AmapRegistrationDto();
		this.amapRegistrationHelper.setNameAmap("les bourbons");

		this.amapRegistrationHelper.setLogin("Amap1");
		this.amapRegistrationHelper.setPassword("123");

		this.amapRegistrationHelper.setNumber("10");
		this.amapRegistrationHelper.setNameOfPlace("du test1");
		this.amapRegistrationHelper.setTypeOfPlace(TypeOfPlace.PLACE);
		this.amapRegistrationHelper.setPostalCode("10000");
		this.amapRegistrationHelper.setTown("ville");

		return "";
	}
}
