package fr.isika.cda.amap_generation.dao.registration;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.amap.AmapAdministrator;
import fr.isika.cda.amap_generation.model.user.Address;
import fr.isika.cda.amap_generation.presentation.registration.AmapRegistrationDto;
import fr.isika.cda.amap_generation.utils.DateUtils;

@Stateless
public class AmapRegistrationDao {

	@PersistenceContext
	private EntityManager entityManager;

	public AmapAdministrator persistence(AmapRegistrationDto helper) {

		// Amap
		Amap amap = new Amap();
		amap.setNameAmap(helper.getNameAmap());
		amap.setSlogan(helper.getSlogan());
		amap.setDateOfSubscription(DateUtils.getTodaysDate());

		// AmapWebMaster
		AmapAdministrator awm = new AmapAdministrator();
		awm.setLoginAwm(helper.getLogin());
		awm.setPasswordAwm(helper.getPassword());

		// Address
		Address address = new Address();
		address.setNumber(helper.getNumber());
		address.setNameOfPlace(helper.getNameOfPlace());
		address.setTypeOfPlace(helper.getTypeOfPlace());
		address.setPostalCode(helper.getPostalCode());
		address.setTown(helper.getTown());

		amap.setLocalisation(address);

		List<AmapAdministrator> awmList = new ArrayList<>();
		awmList.add(awm);

		amap.setAmapWebMaster(awmList);
		awm.setAmap(amap);
		entityManager.persist(amap);

		return awm;

	}

	public List<Amap> getAllRegistered() {
		try {
			return this.entityManager.createQuery("SELECT r FROM Amap p", Amap.class).getResultList();
		} catch(Exception e) {
			List<Amap> amapList = new ArrayList<>();
			return amapList;
		}
	}

}