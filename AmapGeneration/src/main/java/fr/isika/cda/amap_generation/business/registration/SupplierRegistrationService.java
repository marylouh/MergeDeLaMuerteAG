package fr.isika.cda.amap_generation.business.registration;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.registration.SupplierRegistrationDao;
import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.presentation.registration.SupplierRegistrationDto;

@Stateless
public class SupplierRegistrationService {

	@Inject
	private SupplierRegistrationDao supplierRegistrationDao;

	public Long createSupplier(SupplierRegistrationDto supplierRegistrationHelper) {
		return this.supplierRegistrationDao.persistence(supplierRegistrationHelper);
	}

	public List<SupplierRegistrationDto> getAllRegistered() {
		List<SupplierRegistrationDto> finalList = new ArrayList<>();
		List<Supplier> registereds = this.supplierRegistrationDao.getAllRegistered();

		for (Supplier r : registereds) {
			SupplierRegistrationDto rh = new SupplierRegistrationDto();
			rh.setFirstName(r.getFirstName());
			rh.setLastName(r.getLastName());
			rh.setBirthDate(r.getBirthDate());
			rh.setGender(r.getGender());
			rh.setLogin(r.getLogin());
			rh.setPassword(r.getPassword());

			rh.setCompanyName(r.getCompanyName());
			rh.setSiretNumber(rh.getSiretNumber());

			finalList.add(rh);

		}
		return finalList;
	}
}