package fr.isika.cda.amap_generation.dao.subscription;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.amap.BasketFormula;
import fr.isika.cda.amap_generation.model.amap.NameOfFormula;
import fr.isika.cda.amap_generation.presentation.subscription.SubscriptionDto;
import fr.isika.cda.amap_generation.utils.DateUtils;

@Stateless
public class BasketSubscriptionDao {

	@PersistenceContext
	private EntityManager entityManager;

	// Create

	public Long persistence(SubscriptionDto sd) {
		LocalDate currentDate = LocalDate.now();
		LocalDate endOfSubscription = currentDate.plusYears(1);

		BasketFormula bf = new BasketFormula();

		if (sd.getNameOfFormula() == NameOfFormula.FORMULE_SOLO) {
			bf.setSubscriptionCost(BigDecimal.valueOf(7d * 48d));
			bf.setNameOfFormulas(NameOfFormula.FORMULE_SOLO);
		} else if (sd.getNameOfFormula() == NameOfFormula.FORMULE_DUO) {
			bf.setSubscriptionCost(BigDecimal.valueOf(13.5d * 48d));
			bf.setNameOfFormulas(NameOfFormula.FORMULE_DUO);
		} else {
			bf.setSubscriptionCost(BigDecimal.valueOf(25d * 48d));
			bf.setNameOfFormulas(NameOfFormula.FORMULE_FAMILY);
		}

		bf.setActive(true);
		bf.setDateOfSubscription(DateUtils.getTodaysDate());
		bf.setEndOfSubscription(Date.from(endOfSubscription.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		bf.setFormulasDescription("Supergood");

		entityManager.persist(bf);

		return bf.getId();
	}

	// Read

	public BasketFormula getAll() {
		return this.entityManager.createQuery("SELECT bf FROM BasketFormula bf", BasketFormula.class).getSingleResult();
	}

	public Optional<BasketFormula> getBFById(Long id) {
		return Optional.ofNullable(this.entityManager.find(BasketFormula.class, id));
	}

}
