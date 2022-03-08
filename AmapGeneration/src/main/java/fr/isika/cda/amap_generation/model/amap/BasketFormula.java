package fr.isika.cda.amap_generation.model.amap;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.amap_generation.model.user.Member;

@Entity
public class BasketFormula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME_OF_FORMULA")
	@Enumerated(EnumType.STRING)
	private NameOfFormula nameOfFormulas;

	@Column(name = "SUBCRIPTION_COST")
	private BigDecimal subscriptionCost;

	@Temporal(TemporalType.DATE)
	private Date dateOfSubscription;

	@Column(name = "FORMULAS_DESCRIPTION")
	private String formulasDescription;

	@Temporal(TemporalType.DATE)
	private Date endOfSubscription;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = "ID_AMAP")
	private Amap amap;

	@OneToOne
	@JoinColumn(name = "FK_MEMBER")
	private Member member;

	public BasketFormula() {
		super();
	}

	public long getId() {
		return id;
	}

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

	public String getFormulasDescription() {
		return formulasDescription;
	}

	public void setFormulasDescription(String formulasDescription) {
		this.formulasDescription = formulasDescription;
	}

	public Date getEndOfSubscription() {
		return endOfSubscription;
	}

	public void setEndOfSubscription(Date endOfSubscription) {
		this.endOfSubscription = endOfSubscription;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public NameOfFormula getNameOfFormulas() {
		return nameOfFormulas;
	}

	public void setNameOfFormulas(NameOfFormula nameOfFormulas) {
		this.nameOfFormulas = nameOfFormulas;
	}

}
