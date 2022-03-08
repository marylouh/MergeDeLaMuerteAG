package fr.isika.cda.amap_generation.business.subscription;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.subscription.AmapRentalFormulasDao;
import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.presentation.subscription.AmapRentalFormulasDto;
import fr.isika.cda.amap_generation.presentation.subscription.RentalFormulaDto;

@Stateless
public class AmapRentalFormulasService {

	@Inject
	private AmapRentalFormulasDao rentalDao;
	
	public RentalFormulaDto createRentals(AmapRentalFormulasDto rentalHelper) {
		return this.rentalDao.persistence(rentalHelper); 
	}
	
	public Amap findAmap(Long id) {
		return rentalDao.findAmap(id);
	}

	
	
	
}
