package fr.isika.cda.amap_generation.business.DATA_SET;


import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.DATA_SET.DataSetDao;

@Stateless
public class DataSetService {

	@Inject
	private DataSetDao dsd;
	
	public String persistence(){
		dsd.persistence();
		return "index.xhtml";
	}
}
