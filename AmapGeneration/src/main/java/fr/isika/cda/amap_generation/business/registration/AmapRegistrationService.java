package fr.isika.cda.amap_generation.business.registration;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.registration.AmapRegistrationDao;
import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.presentation.registration.AmapRegistrationDto;

@Stateless
public class AmapRegistrationService {
	@Inject
	private AmapRegistrationDao amapRegistrationDao;
	
	public Long createAmap(AmapRegistrationDto amapRegistrationHelper) {
		return this.amapRegistrationDao.persistence(amapRegistrationHelper);
	}

	public List<AmapRegistrationDto> getAllRegistered() {
		List<AmapRegistrationDto> finalList = new ArrayList<>();
		List<Amap> registereds = this.amapRegistrationDao.getAllRegistered();
		
		for(Amap r : registereds) {
			AmapRegistrationDto rh =  new AmapRegistrationDto();
			rh.setNameAmap(r.getNameAmap());
				
			finalList.add(rh);
			
		}
		return finalList;
	}
}
