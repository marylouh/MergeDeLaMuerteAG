package fr.isika.cda.amap_generation.business.authentication;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.dao.authentication.AmapAdminAuthenticationDao;
import fr.isika.cda.amap_generation.model.amap.AmapAdministrator;
import fr.isika.cda.amap_generation.presentation.authentication.AuthenticationDto;


public class AmapAdminAuthenticationService {
	
	@Inject
	private AmapAdminAuthenticationDao authenticationDao;

	public void amapAuthentication(AuthenticationDto authenticationDto) {
		FacesContext context = FacesContext.getCurrentInstance();
		AmapAdministrator awm = authenticationDao.isAmapWebMasterExist(authenticationDto);

		// getSession à true car on créee la session si elle n'existe pas
		if (awm != null) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("idLogin", awm.getId());
			session.setAttribute("idAmap", awm.getAmap().getId());
		} else {
			context.addMessage(null, new FacesMessage("non reconnu"));
		}
	}
	
	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		session.invalidate();
		return "index.xhtml";
	}
}
