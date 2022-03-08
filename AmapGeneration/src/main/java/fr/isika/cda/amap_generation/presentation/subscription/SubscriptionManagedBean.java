package fr.isika.cda.amap_generation.presentation.subscription;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.business.subscription.SubscriptionService;
import fr.isika.cda.amap_generation.model.amap.BasketFormula;
import fr.isika.cda.amap_generation.model.amap.NameOfFormula;


@ManagedBean
@SessionScoped
public class SubscriptionManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5521307542687021004L;

	@Inject
	private SubscriptionService subscriptionService;

	private SubscriptionDto subscriptionDto = new SubscriptionDto();

	public NameOfFormula[] allNameOfFormulas() {
		return NameOfFormula.values();
	}

	public String addSubscriptionSolo() {
		this.subscriptionDto.setNameOfFormula(NameOfFormula.FORMULE_SOLO);
		this.subscriptionDto.setSubscriptionCost(BigDecimal.valueOf(336.0d));
		return this.subscriptionService.persister(subscriptionDto);
	}
	
	public String addSubscriptionDuo() {
		this.subscriptionDto.setNameOfFormula(NameOfFormula.FORMULE_DUO);
		this.subscriptionDto.setSubscriptionCost(BigDecimal.valueOf(648.0d));
		return this.subscriptionService.persister(subscriptionDto);
	}
	
	public String addSubscriptionFamily() {
		this.subscriptionDto.setNameOfFormula(NameOfFormula.FORMULE_FAMILY);
		this.subscriptionDto.setSubscriptionCost(BigDecimal.valueOf(1200.0d));
		return this.subscriptionService.persister(subscriptionDto);
	}
	
	// Getters & Setters

	public BasketFormula getAllBF() {
		return this.subscriptionService.getBF();
	}

	public SubscriptionService getSubscriptionService() {
		return subscriptionService;
	}

	public void setSubscriptionService(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	public SubscriptionDto getSubscriptionDto() {
		return subscriptionDto;
	}

	public void setSubscriptionDto(SubscriptionDto subscriptionDto) {
		this.subscriptionDto = subscriptionDto;
	}


}