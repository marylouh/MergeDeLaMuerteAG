package fr.isika.cda.amap_generation.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatisticsPanel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long Id;
	
	@Column(name = "NB_AMAP")
	private Integer numberOfAmap;
	
	@Column(name = "NB_INSCRITS")
	private Integer numberOfSubscriber;

	@Column(name = "NB_ACHETEURS")
	private Integer numberOfBuyers;
	
	@Column(name = "NB_MESSAGES")
	private Integer numberOfMessageSent; 

	@Column(name = "NB_EVENEMENTS")
	private Integer numberOfEvent;

	@Column(name = "NB_PANIER_VENDUS")
	private Integer numberOfBasketSold;

	@Column(name = "NB_PRODUITS_VENDUS")
	private Integer numberOfProductSold;

	public StatisticsPanel() {
		super();
	}

	public Integer getNumberOfAmap() {
		return numberOfAmap;
	}

	public void setNumberOfAmap(Integer numberOfAmap) {
		this.numberOfAmap = numberOfAmap;
	}

	public Integer getNumberOfSubscriber() {
		return numberOfSubscriber;
	}

	public void setNumberOfSubscriber(Integer numberOfSubscriber) {
		this.numberOfSubscriber = numberOfSubscriber;
	}

	public Integer getNumberOfBuyers() {
		return numberOfBuyers;
	}

	public void setNumberOfBuyers(Integer numberOfBuyers) {
		this.numberOfBuyers = numberOfBuyers;
	}

	public Integer getNumberOfMessageSent() {
		return numberOfMessageSent;
	}

	public void setNumberOfMessageSent(Integer numberOfMessageSent) {
		this.numberOfMessageSent = numberOfMessageSent;
	}

	public Integer getNumberOfEvent() {
		return numberOfEvent;
	}

	public void setNumberOfEvent(Integer numberOfEvent) {
		this.numberOfEvent = numberOfEvent;
	}

	public Integer getNumberOfBasketSold() {
		return numberOfBasketSold;
	}

	public void setNumberOfBasketSold(Integer numberOfBasketSold) {
		this.numberOfBasketSold = numberOfBasketSold;
	}

	public Integer getNumberOfProductSold() {
		return numberOfProductSold;
	}

	public void setNumberOfProductSold(Integer numberOfProductSold) {
		this.numberOfProductSold = numberOfProductSold;
	}

	public Long getId() {
		return Id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatisticsPanel [Id=");
		builder.append(Id);
		builder.append(", numberOfAmap=");
		builder.append(numberOfAmap);
		builder.append(", numberOfSubscriber=");
		builder.append(numberOfSubscriber);
		builder.append(", numberOfBuyers=");
		builder.append(numberOfBuyers);
		builder.append(", numberOfMessageSent=");
		builder.append(numberOfMessageSent);
		builder.append(", numberOfEvent=");
		builder.append(numberOfEvent);
		builder.append(", numberOfBasketSold=");
		builder.append(numberOfBasketSold);
		builder.append(", numberOfProductSold=");
		builder.append(numberOfProductSold);
		builder.append("]");
		return builder.toString();
	}

}
