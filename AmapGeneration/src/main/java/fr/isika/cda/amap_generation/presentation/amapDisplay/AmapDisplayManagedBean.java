
package fr.isika.cda.amap_generation.presentation.amapDisplay;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.business.amapDisplay.AmapDisplayService;
import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.supplier.Supplier;

@ManagedBean
@SessionScoped
public class AmapDisplayManagedBean {

	@Inject
	private AmapDisplayService amapDisplayService;

	String amapName;

	Long amapId;


	public String getAmapName() {
		return amapName;
	}

	public void setAmapName(String amapName) {
		this.amapName = amapName;
	}

	public List<Amap> displayAmaps() {
		return amapDisplayService.displayAmaps();
	}

	public List<Supplier> displaySuppliersByAmap(Long id) {
		return amapDisplayService.displaySuppliersWithAmap(id);
	}

	public void attrListener(ActionEvent event) {
		amapName = (String) event.getComponent().getAttributes().get("view");
	}

	public String renderAmap(Long id) {
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(false);
		this.amapId = (Long)session.getAttribute("idAmap");
		return this.amapDisplayService.renderAmap(id);
	}
	
	public String displayAmapInfosFrontPage() {
		this.amapName = amapDisplayService.displayAmapInfosFrontPage().getNameAmap();
		return this.amapName;
	}

}
