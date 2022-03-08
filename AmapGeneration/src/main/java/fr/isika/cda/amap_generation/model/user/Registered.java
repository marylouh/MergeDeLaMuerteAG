package fr.isika.cda.amap_generation.model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda.amap_generation.model.amap.Amap;

@Entity
@PrimaryKeyJoinColumn(name = "idPerson")
public class Registered extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 771533642949763411L;

	@Column(name = "ALIAS")
	private String alias;

	@Column(name = "REFERENCE_INSCRIPTION")
	private String referenceInsciption;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_CREDIT_CARD")
	private List<CreditCard> creditCards = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_REGISTERED")
	private List<Address> address = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "FK_ADDRESS")
	private List<Address> addresses = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "FK_MEMBER")
	private Member member;


	@ManyToOne
	@JoinColumn(name = "FK_Amap", nullable = false)
	private Amap amap;

	
	public boolean addAddress(Address address) {
		address.setRegistered(this);
		return this.addresses.add(address);
	}

	public boolean addCreditCard(CreditCard creditCard) {
		creditCard.setRegistered(this);
		return this.creditCards.add(creditCard);
	}

	public Registered() {
		String tempRef = UUID.randomUUID().toString().substring(0, 10);
		this.referenceInsciption = tempRef;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getReferenceInsciption() {
		return referenceInsciption;
	}

	public void setReferenceInsciption(String referenceInsciption) {
		this.referenceInsciption = referenceInsciption;
	}

	public List<CreditCard> getCreditCard() {
		return creditCards;
	}

	public void setCreditCard(List<CreditCard> creditCard) {
		this.creditCards = creditCard;
	}

	public List<Address> getAddress() {
		return addresses;
	}

	public void setAddress(List<Address> address) {
		this.addresses = address;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Amap getAmap() {
		return amap;
	}

	public void setAmap(Amap amap) {
		this.amap = amap;
	}
	
	

}
