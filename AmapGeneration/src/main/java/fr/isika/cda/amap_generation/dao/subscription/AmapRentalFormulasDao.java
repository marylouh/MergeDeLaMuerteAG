package fr.isika.cda.amap_generation.dao.subscription;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import fr.isika.cda.amap_generation.presentation.subscription.RentalFormulaDto;

@Stateless
public class AmapRentalFormulasDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private static final String service1 = "Abonnement à des livraisons de paniers bio et locaux.";

	private static final String service2 = "Boutique en ligne accessible à tous.";

	private static final String service3 = "Pôle d'activités proposées par les fourisseurs des associations.";

	public RentalFormulaDto persistence(AmapRentalFormulasDto helperDto) {

		
		RentalFormulaDto dtoReturn = new RentalFormulaDto();

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
			dtoReturn.setTypeFormula("Formule Basique");
			dtoReturn.setPrice(Double.valueOf(40));
			dtoReturn.setService1(service1);
			return dtoReturn;
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
			
			dtoReturn.setTypeFormula("Formule Professionnelle");
			dtoReturn.setPrice(Double.valueOf(60));
			dtoReturn.setService1(service1);
			dtoReturn.setService2(service2);
			
			return dtoReturn;

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
			
			dtoReturn.setTypeFormula("Formule Réseau Social");
			dtoReturn.setPrice(Double.valueOf(80));
			dtoReturn.setService1(service1);
			dtoReturn.setService2(service2);
			dtoReturn.setService3(service3);
			
			return dtoReturn;
		}
		return dtoReturn;
	}

	public Amap findAmap(Long id) {
		try {
			return (Amap) this.entityManager.createQuery("SELECT amap FROM Amap amap WHERE amap.id LIKE :amapId")
					.setParameter("amapId", id).getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
	}
}
