package fr.isika.cda.amap_generation.dao.registration;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.user.Address;
import fr.isika.cda.amap_generation.model.user.Registered;
import fr.isika.cda.amap_generation.presentation.registration.RegistrationDto;

/*
 * Person → Registered
 * Address
 */

@Stateless
public class RegistrationDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Long persistence(RegistrationDto helper) {

		Registered registered = new Registered();
		registered.setFirstName(helper.getFirstName());
		registered.setLastName(helper.getLastName());
		registered.setBirthDate(helper.getBirthDate());
		registered.setGender(helper.getGender());
		registered.setLogin(helper.getLogin());
		registered.setPassword(helper.getPassword());

		LocalDate currentDate = LocalDate.now();
		LocalDate date = registered.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		int age =  Period.between(date, currentDate).getYears();
		registered.setAge(age);
		
		registered.setAlias(helper.getAlias());
		registered.setReferenceInsciption(helper.getReferenceInsciption());

		Address address = new Address();
		address.setNumber(helper.getNumber());
		address.setNameOfPlace(helper.getNameOfPlace());
		address.setTypeOfPlace(helper.getTypeOfPlace());
		address.setPostalCode(helper.getPostalCode());
		address.setTown(helper.getTown());

		List<Address> addressList = new ArrayList<>();
		addressList.add(address);

		registered.setAddress(addressList);

		entityManager.persist(registered);

		return registered.getId();

	}

	public List<Registered> getAllRegistereds() {
		return this.entityManager.createQuery("SELECT r FROM Registered p", Registered.class).getResultList();
	}

}