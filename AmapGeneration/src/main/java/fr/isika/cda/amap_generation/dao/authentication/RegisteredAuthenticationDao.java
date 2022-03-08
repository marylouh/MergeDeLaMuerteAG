package fr.isika.cda.amap_generation.dao.authentication;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.user.Registered;
import fr.isika.cda.amap_generation.presentation.authentication.AuthenticationDto;

@Stateless
public class RegisteredAuthenticationDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	private Registered isLoginExist (AuthenticationDto authenticationDto) {
		try {
			Registered reg = (Registered) this.entityManager
				.createQuery("SELECT reg FROM Registered reg JOIN Person p ON reg.idPerson = p.idPerson WHERE p.login LIKE :regLogin")
				.setParameter("regLogin", authenticationDto.getLogin()).getSingleResult();
		return reg;
		}
		
		catch (Exception e)
		{
			return null;
		}
	}
	
	private Registered isPwdExist (AuthenticationDto authenticationDto) {
		try {
			Registered  reg = (Registered) this.entityManager
					.createQuery("SELECT reg FROM Supplier reg JOIN Person p ON reg.idPerson = p.idPerson WHERE p.password LIKE :regPwd")
					.setParameter("regPwd", authenticationDto.getPassword()).getSingleResult();
			return  reg;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	public Registered isRegisteredExist (AuthenticationDto authenticationDto) {
	
		Registered reg1 = isLoginExist(authenticationDto);
			Registered reg2 = isPwdExist(authenticationDto);
		if (((reg1 !=null)&&(reg2 !=null))&&(reg1.equals(reg2))) {
			return reg1;
			}
		else {
			return null;
		}
		
		
	}
	
}

