package fr.isika.cda.amap_generation.model.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.amap_generation.model.amap.BasketFormula;
import fr.isika.cda.amap_generation.model.amap.Message;

@Entity
public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4357568395095683903L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "TYPE_ADHERENT")
	@Enumerated(EnumType.STRING)
	private TypeOfMember typeOfMember;

	@Column(name = "REFERENCE_ADHERENT")
	private String referenceAdherent;

	@OneToMany
	@JoinColumn(name = "FK_MESSAGELIST")
	private List<Message> messageList = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_REGISTERED")
	private Registered registered;

	@OneToOne
	@JoinColumn(name = "FK_BASKETFORMULA")
	private BasketFormula basketFormula;

	@Column(name = "SUBCRIPTION_COST")
	private BigDecimal subscriptionCost;

	@Temporal(TemporalType.DATE)
	private Date dateOfSubscription;

	@Temporal(TemporalType.DATE)
	private Date endDateOfSubscription;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_ADDRESS_FACTU")
	private Address addressFactu;

	public Member() {
		String tempRef = UUID.randomUUID().toString().substring(0, 10);
		this.referenceAdherent = tempRef;
	}

	public boolean addMessage(Message message, Member recipient) {

		message.setExpeditor(this);
		message.setRecipient(recipient);
		message.setConversation(null);
		return this.messageList.add(message);
	}

	public void ugradeToMember(Registered registered) {
		registered.setMember(this);
		this.setRegistered(registered);
	}

	public TypeOfMember getTypeOfMember() {
		return typeOfMember;
	}

	public void setTypeOfMember(TypeOfMember typeOfMember) {
		this.typeOfMember = typeOfMember;
	}

	public String getReferenceAdherent() {
		return referenceAdherent;
	}

	public void setReferenceAdherent(String referenceAdherent) {
		this.referenceAdherent = referenceAdherent;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public Registered getRegistered() {
		return registered;
	}

	public void setRegistered(Registered registered) {
		this.registered = registered;
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

	public Long getId() {
		return id;
	}

	public Address getAddressFactu() {
		return addressFactu;
	}

	public void setAddressFactu(Address addressFactu) {
		this.addressFactu = addressFactu;
	}

}
