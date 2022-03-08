package fr.isika.cda.amap_generation.business.registration;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.registration.RegistrationDao;
import fr.isika.cda.amap_generation.model.user.Registered;
import fr.isika.cda.amap_generation.presentation.registration.RegistrationDto;

@Stateless
public class RegistrationService {

	@Inject
	private RegistrationDao registrationDao;
	
	public Long register(RegistrationDto registrationHelper) {
		// traitement couche service 
		// → calculer age de la personne
		// → lui souhaiter son anniversaire si c'est son anniversaire
		
		
		return this.registrationDao.persistence(registrationHelper);
	}
	
	public List<RegistrationDto> getAllRegistered() {
		List<RegistrationDto> finalList = new ArrayList<>();
		List<Registered> registereds = this.registrationDao.getAllRegistereds();
		
		for(Registered r : registereds) {
			RegistrationDto rh =  new RegistrationDto();
			rh.setFirstName(r.getFirstName());
			rh.setLastName(r.getLastName());
			rh.setBirthDate(r.getBirthDate());
			rh.setGender(r.getGender());
			rh.setLogin(r.getLogin());
			rh.setPassword(r.getPassword());
			
			rh.setAlias(r.getAlias());
			rh.setReferenceInsciption(rh.getReferenceInsciption());
			
			finalList.add(rh);
			
		}
		return finalList;
	}
}
