package fr.isika.cda.amap_generation.presentation.subscription;

import java.io.Serializable;
import java.math.BigDecimal;

import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.amap.NameOfFormula;
import fr.isika.cda.amap_generation.model.user.Member;

public class SubscriptionDto implements Serializable {

	private static final long serialVersionUID = -2596978776126573231L;

	// Pour s'abonner aux paniers de notre AMAP, c'est très simple !
	// Veuillez compléter le formulaire ci-dessous en choisissant le panier "coup de
	// coeur"
	// qui correspond à vos envies et vos besoins.

	private Amap amap;
	private NameOfFormula nameOfFormula;
	private BigDecimal subscriptionCost;
	private Member member;

	public Amap getAmap() {
		return amap;
	}

	public void setAmap(Amap amap) {
		this.amap = amap;
	}

	public NameOfFormula getNameOfFormula() {
		return nameOfFormula;
	}

	public void setNameOfFormula(NameOfFormula nameOfFormula) {
		this.nameOfFormula = nameOfFormula;
	}

	public BigDecimal getSubscriptionCost() {
		return subscriptionCost;
	}

	public void setSubscriptionCost(BigDecimal subscriptionCost) {
		this.subscriptionCost = subscriptionCost;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}