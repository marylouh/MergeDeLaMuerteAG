package fr.isika.cda.amap_generation.dao.registration;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.model.user.Address;
import fr.isika.cda.amap_generation.presentation.registration.SupplierRegistrationDto;

@Stateless
public class SupplierRegistrationDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Long persistence(SupplierRegistrationDto helper) {

		Supplier sup = new Supplier();
		sup.setFirstName(helper.getFirstName());
		sup.setLastName(helper.getLastName());
		sup.setBirthDate(helper.getBirthDate());
		sup.setGender(helper.getGender());
		sup.setLogin(helper.getLogin());
		sup.setPassword(helper.getPassword());

		LocalDate currentDate = LocalDate.now();
		LocalDate date = sup.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int age = Period.between(date, currentDate).getYears();
		System.out.println(age);
		sup.setAge(age);

		sup.setCompanyName(helper.getCompanyName());
		sup.setSiretNumber(helper.getSiretNumber());
		sup.setDateOfEntry(helper.getDateOfEntry());

		Address address = new Address();
		address.setNumber(helper.getNumber());
		address.setNameOfPlace(helper.getNameOfPlace());
		address.setTypeOfPlace(helper.getTypeOfPlace());
		address.setPostalCode(helper.getPostalCode());
		address.setTown(helper.getTown());

		List<Address> addressList = new ArrayList<>();
		addressList.add(address);

		Amap amap = this.entityManager.find(Amap.class, helper.getIdAmap());
		sup.setAmap(amap);

		entityManager.persist(sup);

		return sup.getId();

	}

	public List<Supplier> getAllRegistered() {
		return this.entityManager.createQuery("SELECT r FROM Supplier p", Supplier.class).getResultList();
	}

}