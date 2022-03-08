package fr.isika.cda.amap_generation.business.subscription;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.subscription.AmapRentalFormulasDao;
import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.presentation.subscription.AmapRentalFormulasDto;

@Stateless
public class AmapRentalFormulasService {

	@Inject
	private AmapRentalFormulasDao rentalDao;
	
	public String createRentals(AmapRentalFormulasDto rentalHelper) {
		this.rentalDao.persistence(rentalHelper);
		return "index.xhtml";
	}
	
	public Amap findAmap(Long id) {
		return rentalDao.findAmap(id);
	}

	
	
	
}
