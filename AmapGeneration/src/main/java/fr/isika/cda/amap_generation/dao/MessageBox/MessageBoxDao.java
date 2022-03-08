package fr.isika.cda.amap_generation.dao.MessageBox;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class MessageBoxDao {

	@PersistenceContext
	private EntityManager entityManager;
	

}
