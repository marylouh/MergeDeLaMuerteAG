package fr.isika.cda.amap_generation.dao.subscription;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.amap.ActivityCenterRental;
import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.amap.BasketRental;
import fr.isika.cda.amap_generation.model.amap.ShopRental;
import fr.isika.cda.amap_generation.model.amap.TypeOfRentalFormulas;
import fr.isika.cda.amap_generation.presentation.subscription.AmapRentalFormulasDto;

@Stateless
public class AmapRentalFormulasDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void persistence(AmapRentalFormulasDto helperDto) {

		LocalDate currentDate = LocalDate.now();
		LocalDate enOfSubscription = currentDate.plusYears(1);

		BasketRental br = new BasketRental();
		br.setActive(true);
		br.setAmap(helperDto.getAmap());

		br.setDateOfSubscription(Date.from(currentDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

		br.setEndDateOfSubscription(
				Date.from(enOfSubscription.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

		br.setSubscriptionCost(BigDecimal.valueOf(40));
		br.setPossibleNumberOfBaskets(3);

		TypeOfRentalFormulas type = helperDto.getTypeOfRentalFormulas();

		if (type.equals(TypeOfRentalFormulas.FORMULE_1)) {
			helperDto.getAmap().setTypeOfRentalFormulas(TypeOfRentalFormulas.FORMULE_1);
			this.entityManager.merge(helperDto.getAmap());
		}

		else if (type.equals(TypeOfRentalFormulas.FORMULE_2)) {

			ShopRental sr = new ShopRental();

			sr.setActive(true);
			sr.setAmap(helperDto.getAmap());

			sr.setDateOfSubscription(Date.from(currentDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

			sr.setEndDateOfSubscription(
					Date.from(enOfSubscription.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

			sr.setSubscriptionCost(BigDecimal.valueOf(20));
			sr.setPossibleNumberOfProducts(50);

			helperDto.getAmap().setTypeOfRentalFormulas(TypeOfRentalFormulas.FORMULE_2);
			this.entityManager.merge(helperDto.getAmap());

			entityManager.persist(sr);

		} else if (type.equals(TypeOfRentalFormulas.FORMULE3)) {

			ActivityCenterRental acr = new ActivityCenterRental();

			acr.setActive(true);
			acr.setAmap(helperDto.getAmap());

			acr.setDateOfSubscription(Date.from(currentDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

			acr.setEndDateOfSubscription(
					Date.from(enOfSubscription.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

			acr.setSubscriptionCost(BigDecimal.valueOf(20));
			acr.setPossibleNumberOfActivities(15);

			helperDto.getAmap().setTypeOfRentalFormulas(TypeOfRentalFormulas.FORMULE3);
			this.entityManager.merge(helperDto.getAmap());

			entityManager.persist(acr);
		}
	}

	public Amap findAmap(Long id) {
		try {
			Amap amap = (Amap) this.entityManager.find(Amap.class, id);
			return amap;
		}

		catch (Exception e) {
			return null;
		}
	}
}
