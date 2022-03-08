package fr.isika.cda.amap_generation.business.registration;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.dao.registration.AmapRegistrationDao;
import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.amap.AmapAdministrator;
import fr.isika.cda.amap_generation.presentation.registration.AmapRegistrationDto;

@Stateless
public class AmapRegistrationService {
	@Inject
	private AmapRegistrationDao amapRegistrationDao;

	public AmapAdministrator createAmap(AmapRegistrationDto amapRegistrationHelper) {
		AmapAdministrator aa = this.amapRegistrationDao.persistence(amapRegistrationHelper);
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(true);
		session.setAttribute("aaConnected", aa);
		session.setAttribute("idLogin", aa.getId());
		session.setAttribute("idAmap", aa.getAmap().getId());
		return aa;
		
	}

	public List<AmapRegistrationDto> getAllRegistered() {
		try {

			List<AmapRegistrationDto> finalList = new ArrayList<>();
			List<Amap> registereds = this.amapRegistrationDao.getAllRegistered();

			for (Amap r : registereds) {
				AmapRegistrationDto rh = new AmapRegistrationDto();
				rh.setNameAmap(r.getNameAmap());

				finalList.add(rh);

			}
			return finalList;
		} catch (Exception e) {
			List<AmapRegistrationDto> dto = new ArrayList<>();
			return dto;
		}
	}
}
