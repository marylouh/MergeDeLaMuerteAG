package fr.isika.cda.amap_generation.dao.profileManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.amap.AmapAdministrator;
import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.model.user.Administrator;
import fr.isika.cda.amap_generation.model.user.Member;
import fr.isika.cda.amap_generation.model.user.Registered;
import fr.isika.cda.amap_generation.model.user.TypeOfMember;

@Stateless
public class ProfileManagementDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
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
	
	public List<Registered> getAllRegisteredsWithAmap(Long id){
		try {
		return this.entityManager
				.createQuery("SELECT r FROM Registered r JOIN Amap a ON r.amap = r.id WHERE a.id LIKE :amapId", Registered.class)
				.setParameter("amapId", id)
				.getResultList();

		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Member> getAllRegisteredMembers(Long id){
		try {
		return this.entityManager
				.createQuery("SELECT m FROM Member m JOIN Registered r ON m.registered = r.member WHERE r.member LIKE :registeredId", Member.class)
				.setParameter("registredId", id)
				.getResultList();

	} catch (Exception e) {
		return null;
	}
	}
		
	public List<Member> getAllMemberByType(TypeOfMember typeOfMember){
try {
		return this.entityManager
				.createQuery("SELECT m FROM Member m WHERE m.typeOfMember LIKE :tom", Member.class)
				.setParameter("tom", typeOfMember)
				.getResultList();

	} catch (Exception e) {
		return null;
	}
	}
	
	public Supplier getSupplierById(Long id) {
		try {
		return this.entityManager
				.createQuery("SELECT s FROM Supplier s WHERE s.id LIKE :supId", Supplier.class)
				.setParameter("supId", id)
				.getSingleResult();
	} catch (Exception e) {
		return null;
	}
	}

	public Registered getRegisteredById(Long id) {
		try {
		return this.entityManager
				.createQuery("SELECT r FROM Registered r WHERE r.id LIKE :regId", Registered.class)
				.setParameter("regId", id)
				.getSingleResult();

	} catch (Exception e) {
		return null;
	}
	}
	
	public Member getMemberInRegistredTable(Long id) {
		try {
			return this.entityManager
			.createQuery("SELECT r.member FROM Registered r WHERE r.id LIKE :regId", Member.class)
			.setParameter("regId", id)
			.getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}
	
	public AmapAdministrator getAmapAdministartorById(Long id) {
		try {
		return this.entityManager
				.createQuery("SELECT aa FROM AmapAdministrator aa WHERE aa.id LIKE :aaId", AmapAdministrator.class)
				.setParameter("aaId", id)
				.getSingleResult();
	} catch (Exception e) {
		return null;
	}
	}
	
	public Administrator getAdministratorById(Long id) {
	try {
		return this.entityManager
				.createQuery("SELECT a FROM Administrator a WHERE a.id LIKE :aId", Administrator.class)
				.setParameter("aId", id)
				.getSingleResult();
	} catch (Exception e) {
		return null;
	}
	}
	
}
