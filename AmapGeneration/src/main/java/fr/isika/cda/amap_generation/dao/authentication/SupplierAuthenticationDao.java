package fr.isika.cda.amap_generation.dao.authentication;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.presentation.authentication.AuthenticationDto;

@Stateless
public class SupplierAuthenticationDao {

	@PersistenceContext
	private EntityManager entityManager;

	private Supplier isLoginExist(AuthenticationDto authenticationDto) {
		try {
			Supplier sup = (Supplier) this.entityManager.createQuery(
					"SELECT sup FROM Supplier sup JOIN Person p ON sup.idPerson = p.idPerson WHERE p.login LIKE :supLogin")
					.setParameter("supLogin", authenticationDto.getLogin()).getSingleResult();
			System.out.println(
					"-------------------------------------------------------------a fait la query " + sup.getLogin());
			return sup;
		}

		catch (Exception e) {
			return null;
		}
	}

	private Supplier isPwdExist(AuthenticationDto authenticationDto) {
		try {
			Supplier sup = (Supplier) this.entityManager.createQuery(
					"SELECT sup FROM Supplier sup JOIN Person p ON sup.idPerson = p.idPerson WHERE p.password LIKE :supPwd")
					.setParameter("supPwd", authenticationDto.getPassword()).getSingleResult();
			System.out.println("-------------------------------------------------------------a fait la query "
					+ sup.getPassword());
			return sup;
		} catch (Exception e) {
			return null;
		}
	}

	public Supplier isSupplierExist(AuthenticationDto authenticationDto) {

		Supplier sup1 = isLoginExist(authenticationDto);
		Supplier sup2 = isPwdExist(authenticationDto);
		if (((sup1 != null) && (sup2 != null)) && (sup1.equals(sup2))) {
			return sup1;
		} else {
			return null;
		}

	}

}