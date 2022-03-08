package fr.isika.cda.amap_generation.business.authentication;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.dao.authentication.AdminAuthenticationDao;
import fr.isika.cda.amap_generation.model.user.Administrator;
import fr.isika.cda.amap_generation.presentation.authentication.AdminAuthenticationDto;


public class AdminAuthenticationService {
	
	@Inject
	private AdminAuthenticationDao adminAuthenticationDao;

	public String adminAuthentication(AdminAuthenticationDto adminAuthenticationDto) {
		FacesContext context = FacesContext.getCurrentInstance();
		Administrator awm = adminAuthenticationDao.isAdminExist(adminAuthenticationDto);

		if (awm != null) {

			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("idLogin", awm.getId());
			System.out.println("***********************************************connecté");
			return "";
		} else {
			context.addMessage(null, new FacesMessage("non reconnu"));
			System.out.println("***********************************************non connecté");
			return "login.xhtml";
		}
	}
	
	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		session.invalidate();
		return "index.xhtml";
	}
}
