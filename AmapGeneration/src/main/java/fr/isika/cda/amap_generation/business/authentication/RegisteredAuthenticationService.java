package fr.isika.cda.amap_generation.business.authentication;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.dao.authentication.RegisteredAuthenticationDao;
import fr.isika.cda.amap_generation.model.user.Registered;
import fr.isika.cda.amap_generation.presentation.authentication.AuthenticationDto;

@Stateless
public class RegisteredAuthenticationService {

	@Inject
	private RegisteredAuthenticationDao authenticationDao;
	
	public String registeredAuthentication(AuthenticationDto authenticationDto) {

		FacesContext context = FacesContext.getCurrentInstance();

		Registered reg = authenticationDao.isRegisteredExist(authenticationDto);

		if (reg != null) {

			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("idLogin", reg.getId());
			return "index.xhtml";
		} else {
			context.addMessage(null, new FacesMessage("non reconnu"));
			return "login.xhtml";
		}
	}
	
	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		session.invalidate();
		return "indexAmap.xhtml";
	}

}
