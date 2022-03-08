package fr.isika.cda.amap_generation.business.amapDisplay;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.dao.amapDisplay.AmapDisplayDao;
import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.supplier.Supplier;

@Stateless
public class AmapDisplayService {

	@Inject
	private AmapDisplayDao amapDisplayDao;
	

	public List<Amap> displayAmaps() {
		return amapDisplayDao.getAllAmaps();
	}

	public List<Supplier> displaySuppliersWithAmap(Long id) {
		return amapDisplayDao.getAllSuppliersWithAmap(id);
	}
	
	public String renderAmap(Long id) {
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(true);
		session.setAttribute("idAmap", id);
		return "indexAmap.xhtml?faces-redirect=true";
	}
	
	public Amap displayAmapInfosFrontPage() {
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(false);
		Long amapId = (Long)session.getAttribute("idAmap");
		return amapDisplayDao.getAmapById(amapId);
	}
}
