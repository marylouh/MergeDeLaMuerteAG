package fr.isika.cda.amap_generation.presentation.DATA_SET;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.business.DATA_SET.DataSetService;

@SessionScoped
@ManagedBean
public class DataSetManagedBean {

	@Inject
	DataSetService dss = new DataSetService();
	
	public String dataSet() {
		return dss.persistence();
	}
}
