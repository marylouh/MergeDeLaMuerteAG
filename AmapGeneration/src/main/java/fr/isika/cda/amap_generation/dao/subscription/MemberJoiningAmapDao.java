package fr.isika.cda.amap_generation.dao.subscription;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.user.Address;
import fr.isika.cda.amap_generation.model.user.Member;
import fr.isika.cda.amap_generation.presentation.subscription.MemberJoiningAmapDto;

@Stateless
public class MemberJoiningAmapDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Long persistence(MemberJoiningAmapDto helperDto) {

		LocalDate currentDate = LocalDate.now();
		LocalDate enOfSubscription = currentDate.plusYears(1);

		Member member = new Member();
		member.setActive(true);

		member.setDateOfSubscription(Date.from(currentDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

		member.setEndDateOfSubscription(
				Date.from(enOfSubscription.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

		member.setSubscriptionCost(BigDecimal.valueOf(50));
		member.setTypeOfMember(helperDto.getTypeOfMember());

		entityManager.persist(member);

		Address address = new Address();
		address.setNumber(helperDto.getNumber());
		address.setNameOfPlace(helperDto.getNameOfPlace());
		address.setTypeOfPlace(helperDto.getTypeOfPlace());
		address.setPostalCode(helperDto.getPostalCode());
		address.setTown(helperDto.getTown());

		member.setAddressFactu(address);

		return member.getId();

		
	}
}
