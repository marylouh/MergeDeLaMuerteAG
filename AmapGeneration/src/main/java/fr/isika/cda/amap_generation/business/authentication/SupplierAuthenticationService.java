package fr.isika.cda.amap_generation.business.authentication;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import fr.isika.cda.amap_generation.dao.authentication.SupplierAuthenticationDao;
import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.presentation.authentication.AuthenticationDto;

@Stateless
public class SupplierAuthenticationService {
	
	@Inject
	private SupplierAuthenticationDao authenticationDao;
	
	public String supplierAuthentication(AuthenticationDto authenticationDto) {
		FacesContext context = FacesContext.getCurrentInstance();

		Supplier sup = authenticationDao.isSupplierExist(authenticationDto);

		if (sup != null) {

			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("idLogin", sup.getId());
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
