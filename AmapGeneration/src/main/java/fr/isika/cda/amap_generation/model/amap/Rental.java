package fr.isika.cda.amap_generation.model.amap;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "SUBCRIPTION_COST")
	private BigDecimal subscriptionCost;

	@Temporal(TemporalType.DATE)
	private Date dateOfSubscription;

	@Temporal(TemporalType.DATE)
	private Date endDateOfSubscription;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = "ID_AMAP")
	private Amap amap;

	// ----------Getters & Setters-------------------

	public BigDecimal getSubscriptionCost() {
		return subscriptionCost;
	}

	public void setSubscriptionCost(BigDecimal subscriptionCost) {
		this.subscriptionCost = subscriptionCost;
	}

	public Date getDateOfSubscription() {
		return dateOfSubscription;
	}

	public void setDateOfSubscription(Date dateOfSubscription) {
		this.dateOfSubscription = dateOfSubscription;
	}

	public Date getEndDateOfSubscription() {
		return endDateOfSubscription;
	}

	public void setEndDateOfSubscription(Date endDateOfSubscription) {
		this.endDateOfSubscription = endDateOfSubscription;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Amap getAmap() {
		return amap;
	}

	public void setAmap(Amap amap) {
		this.amap = amap;
	}

	public long getId() {
		return id;
	}
	
	// -------------------To String------------------------

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rental [id=");
		builder.append(id);
		builder.append(", subscriptionCost=");
		builder.append(subscriptionCost);
		builder.append(", dateOfSubscription=");
		builder.append(dateOfSubscription);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", amap=");
		builder.append(amap);
		builder.append("]");
		return builder.toString();
	}



}

