package fr.isika.cda.amap_generation.dao.authentication;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.amap.AmapAdministrator;
import fr.isika.cda.amap_generation.presentation.authentication.AuthenticationDto;

@Stateless
public class AmapAdminAuthenticationDao {

	@PersistenceContext
	private EntityManager entityManager;

	private AmapAdministrator isLoginExist(AuthenticationDto authenticationDto) {
		try {
			return (AmapAdministrator) this.entityManager
					.createQuery("SELECT aw FROM AmapAdministrator aw WHERE aw.loginAwm LIKE :login")
					.setParameter("login", authenticationDto.getLogin()).getSingleResult();
		}

		catch (Exception e) {
			return null;
		}
	}

	private AmapAdministrator isPwdExist(AuthenticationDto authenticationDto) {
		try {
			return (AmapAdministrator) this.entityManager
					.createQuery("SELECT aw FROM AmapAdministrator aw WHERE aw.passwordAwm LIKE :pwd")
					.setParameter("pwd", authenticationDto.getPassword()).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public AmapAdministrator isAmapWebMasterExist(AuthenticationDto authenticationDto) {

		AmapAdministrator awm1 = isLoginExist(authenticationDto);
		AmapAdministrator awm2 = isPwdExist(authenticationDto);
		if (((awm1 != null) && (awm2 != null)) && (awm1.equals(awm2))) {
			return awm1;
		} else {
			return null;
		}

	}
}
