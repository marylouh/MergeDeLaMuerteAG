package fr.isika.cda.amap_generation.business.subscription;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.subscription.BasketSubscriptionDao;
import fr.isika.cda.amap_generation.model.amap.BasketFormula;
import fr.isika.cda.amap_generation.presentation.subscription.SubscriptionDto;

@Stateless
public class SubscriptionService {

	@Inject
	private BasketSubscriptionDao repository;

	// Create

	public String persister(SubscriptionDto subscriptionDto) {
		 this.repository.persistence(subscriptionDto);
		 return "index.xhtml?faces-redirect=true";
	}

	public BasketFormula getBF() {
		return this.repository.getAll();
	}

	public Optional<BasketFormula> getBFById(Long id) {
		return this.repository.getBFById(id);
	}

}
