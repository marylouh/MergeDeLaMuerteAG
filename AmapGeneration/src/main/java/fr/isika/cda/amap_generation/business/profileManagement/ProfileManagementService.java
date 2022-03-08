package fr.isika.cda.amap_generation.business.profileManagement;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.dao.profileManagement.ProfileManagementDao;
import fr.isika.cda.amap_generation.model.amap.AmapAdministrator;
import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.model.user.Administrator;
import fr.isika.cda.amap_generation.model.user.Member;
import fr.isika.cda.amap_generation.model.user.Registered;

@Stateless
public class ProfileManagementService {

	@Inject
	private ProfileManagementDao profileManagementDao;
	
	public void verificationOfSessionInfosAndSessionFilling() {
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(true);
		Long amapId = (Long)session.getAttribute("idAmap");
		Long idLogin = (Long)session.getAttribute("idLogin");
		
		if (amapId !=null) {
		if(this.profileManagementDao.getAllSuppliersWithAmap(amapId) != null) {
		
			Supplier supplier = this.profileManagementDao.getSupplierById(idLogin);
			session.setAttribute("supplierConnected", supplier);
			
		}else if(this.profileManagementDao.getAllRegisteredsWithAmap(amapId) != null) {
			Registered registered = this.profileManagementDao.getRegisteredById(idLogin);
			session.setAttribute("registeredConnected", registered);
			
			Member member = this.profileManagementDao.getMemberInRegistredTable(registered.getId());
			session.setAttribute("memberConnected", member);
						
		}
		}else {
			
			AmapAdministrator amapAdministrator = this.profileManagementDao.getAmapAdministartorById(idLogin);
			session.setAttribute("amapAdminConnected", amapAdministrator);
			
			Administrator administrator = this.profileManagementDao.getAdministratorById(idLogin);
			session.setAttribute("memberConnected", administrator);
		}
	}
}
