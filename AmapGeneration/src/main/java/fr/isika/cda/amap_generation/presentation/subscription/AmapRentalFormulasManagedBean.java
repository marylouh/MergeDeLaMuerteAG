package fr.isika.cda.amap_generation.presentation.subscription;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.business.subscription.AmapRentalFormulasService;
import fr.isika.cda.amap_generation.model.amap.TypeOfRentalFormulas;


@ManagedBean
@SessionScoped
public class AmapRentalFormulasManagedBean {
	@Inject
	private AmapRentalFormulasService rentalService;

	private AmapRentalFormulasDto rentalDto = new AmapRentalFormulasDto();

	public AmapRentalFormulasService getRentalService() {
		return rentalService;
	}

	public void setRentalService(AmapRentalFormulasService rentalService) {
		this.rentalService = rentalService;
	}

	public AmapRentalFormulasDto getRentalDto() {
		return rentalDto;
	}

	public void setRentalDto(AmapRentalFormulasDto rentalDto) {
		this.rentalDto = rentalDto;
	}

	public String subscriptionRentalFirstFormulas() {
		this.rentalDto.setTypeOfRentalFormulas(TypeOfRentalFormulas.FORMULE_1);
		
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);  
		Long idAmap = (Long)session.getAttribute("idAmap");
		
		this.rentalDto.setAmap(rentalService.findAmap(idAmap));
		return rentalService.createRentals(rentalDto);
		
	}
	public String subscriptionRentalSecondFormulas() {
		this.rentalDto.setTypeOfRentalFormulas(TypeOfRentalFormulas.FORMULE_2);
		
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);  
		Long idAmap = (Long)session.getAttribute("idAmap");

		
		this.rentalDto.setAmap(rentalService.findAmap(idAmap));
		return rentalService.createRentals(rentalDto);
		
	}
	
	public String subscriptionRentalThirdFormulas() {
		this.rentalDto.setTypeOfRentalFormulas(TypeOfRentalFormulas.FORMULE3);
		
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);  
		Long idAmap = (Long)session.getAttribute("idAmap");
		
		this.rentalDto.setAmap(rentalService.findAmap(idAmap));
		return rentalService.createRentals(rentalDto);
		
	}
}
