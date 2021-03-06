package fr.isika.cda.amap_generation.dao.amapDisplay;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.supplier.Supplier;

@Stateless
public class AmapDisplayDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Amap> getAllAmaps(){
		try {
		return this.entityManager
				.createQuery("SELECT a FROM Amap a", Amap.class)
				.getResultList();
		} catch (Exception e) {
	return null;
		}
	}

	public List<Supplier> getAllSuppliersWithAmap(Long id){
		try {
	
		return this.entityManager
				.createQuery("SELECT s FROM Supplier s JOIN Amap a ON s.amap = a.id WHERE a.id LIKE :amapId", Supplier.class)
				.setParameter("amapId", id)
				.getResultList();
	} catch (Exception e) {
		return null;
	}
	}
	
	public Amap getAmapById(Long id) {
		try {
		return this.entityManager
				.createQuery("SELECT a FROM Amap a WHERE a.id LIKE :amapId", Amap.class)
				.setParameter("amapId", id)
				.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
		

