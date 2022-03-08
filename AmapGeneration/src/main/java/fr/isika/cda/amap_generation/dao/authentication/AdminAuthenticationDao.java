package fr.isika.cda.amap_generation.dao.authentication;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.user.Administrator;
import fr.isika.cda.amap_generation.presentation.authentication.AdminAuthenticationDto;

@Stateless
public class AdminAuthenticationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void persistence() {
		Administrator admin = new Administrator();
		admin.setLoginAdmin("admin");
		admin.setPasswordAdmin("admin");
		
		entityManager.persist(admin);
	}

	private Administrator isLoginExist(AdminAuthenticationDto adminAuthenticationDto) {
		try {
			return (Administrator) this.entityManager
					.createQuery("SELECT a FROM Administrator a WHERE a.loginAdmin LIKE :logAdmin")
					.setParameter("logAdmin", adminAuthenticationDto.getLoginAdmin()).getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
	}

	private Administrator isPwdExist(AdminAuthenticationDto adminAuthenticationDto) {
		try {
			return (Administrator) this.entityManager
					.createQuery("SELECT a FROM Administrator a WHERE a.passwordAdmin LIKE :pwdAdmin")
					.setParameter("pwdAdmin", adminAuthenticationDto.getPasswordAdmin()).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public Administrator isAdminExist(AdminAuthenticationDto adminAuthenticationDto) {
		Administrator awm1 = isLoginExist(adminAuthenticationDto);
		Administrator awm2 = isPwdExist(adminAuthenticationDto);
		if (((awm1 != null) && (awm2 != null)) && (awm1.equals(awm2))) {
			return awm1;
		} else {
			return null;
		}
		
		

	}
}
