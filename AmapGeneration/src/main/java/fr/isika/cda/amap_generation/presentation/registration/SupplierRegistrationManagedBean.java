package fr.isika.cda.amap_generation.presentation.registration;

import java.io.Serializable;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.business.registration.SupplierRegistrationService;
import fr.isika.cda.amap_generation.model.user.Gender;
import fr.isika.cda.amap_generation.model.user.TypeOfPlace;

@ManagedBean
@SessionScoped
public class SupplierRegistrationManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 151569845L;
	
	@Inject
	private SupplierRegistrationService supplierRegistrationService;
	
	private SupplierRegistrationDto supplierRegistrationHelper = new SupplierRegistrationDto();
	
	public Gender [] allGenders() {
		return Gender.values();
	}
	
	public TypeOfPlace[] allTypeOfPlaces() {
		return TypeOfPlace.values();
	}

	public SupplierRegistrationDto getSupplierRegistrationHelper() {
		return supplierRegistrationHelper;
	}

	public void setSupplierRegistrationHelper(SupplierRegistrationDto supplierRegistrationHelper) {
		this.supplierRegistrationHelper = supplierRegistrationHelper;
	}

	public void setSupplierRegistrationService(SupplierRegistrationService supplierRegistrationService) {
		this.supplierRegistrationService = supplierRegistrationService;
	}

	public String registerToAmap() {
		supplierRegistrationService.createSupplier(supplierRegistrationHelper);
		return "registered.xhtml?faces-redirect=true";
	}
	
	public String demo() throws ParseException {
		this.supplierRegistrationHelper = new SupplierRegistrationDto();
		this.supplierRegistrationHelper.setFirstName("Elise");
		this.supplierRegistrationHelper.setLastName("Coucou");
		
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		this.supplierRegistrationHelper.setBirthDate(sf.parse("01/01/2000"));
		
		this.supplierRegistrationHelper.setGender(Gender.MADAME);
		this.supplierRegistrationHelper.setLogin("login");
		this.supplierRegistrationHelper.setPassword("123");
		this.supplierRegistrationHelper.setCompanyName("les fleurs bleues");
		this.supplierRegistrationHelper.setNumber("10");
		this.supplierRegistrationHelper.setNameOfPlace("du test1");
		this.supplierRegistrationHelper.setTypeOfPlace(TypeOfPlace.PLACE);
		this.supplierRegistrationHelper.setPostalCode("10000");
		this.supplierRegistrationHelper.setTown("ville");
		
		return "";
	}
	
	
	
	
	
}
